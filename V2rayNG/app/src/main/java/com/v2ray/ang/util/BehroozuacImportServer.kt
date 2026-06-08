package com.v2ray.ang.util

import com.v2ray.ang.AppConfig
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Inet4Address
import java.net.NetworkInterface
import java.net.ServerSocket
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import kotlin.concurrent.thread

class BehroozuacImportServer(
    private val onConfigReceived: (String) -> Unit
) {
    private var serverSocket: ServerSocket? = null
    private var worker: Thread? = null
    var url: String? = null
        private set

    fun start(): Boolean {
        if (serverSocket != null) {
            return true
        }

        val host = findLocalIpv4() ?: return false
        val socket = (37890..37909).firstNotNullOfOrNull { port ->
            runCatching { ServerSocket(port).apply { reuseAddress = true } }.getOrNull()
        } ?: return false

        serverSocket = socket
        url = "http://$host:${socket.localPort}/"
        worker = thread(name = "BehroozuacImportServer", isDaemon = true) {
            while (!socket.isClosed) {
                val client = runCatching { socket.accept() }.getOrNull() ?: break
                runCatching {
                    client.use {
                        val reader = BufferedReader(InputStreamReader(it.getInputStream(), StandardCharsets.UTF_8))
                        val requestLine = reader.readLine().orEmpty()
                        var contentLength = 0
                        while (true) {
                            val line = reader.readLine() ?: break
                            if (line.isEmpty()) break
                            if (line.startsWith("Content-Length:", ignoreCase = true)) {
                                contentLength = line.substringAfter(':').trim().toIntOrNull() ?: 0
                            }
                        }

                        val body = if (contentLength > 0) {
                            CharArray(contentLength).also { chars -> reader.read(chars, 0, contentLength) }.concatToString()
                        } else {
                            ""
                        }

                        val isPost = requestLine.startsWith("POST ", ignoreCase = true)
                        if (isPost) {
                            val config = parseFormConfig(body)
                            if (config.isNotBlank()) {
                                onConfigReceived(config)
                                writeResponse(it.getOutputStream(), successPage())
                            } else {
                                writeResponse(it.getOutputStream(), formPage("No config text received."))
                            }
                        } else {
                            writeResponse(it.getOutputStream(), formPage())
                        }
                    }
                }.onFailure { LogUtil.e(AppConfig.TAG, "Import server request failed", it) }
            }
        }
        return true
    }

    fun stop() {
        runCatching { serverSocket?.close() }
        serverSocket = null
        url = null
    }

    private fun parseFormConfig(body: String): String {
        val value = body.split('&')
            .firstOrNull { it.startsWith("configs=") }
            ?.substringAfter('=')
            .orEmpty()
            .replace("+", " ")
        return URLDecoder.decode(value, StandardCharsets.UTF_8.name()).trim()
    }

    private fun writeResponse(output: java.io.OutputStream, html: String) {
        val bytes = html.toByteArray(StandardCharsets.UTF_8)
        val header = "HTTP/1.1 200 OK\r\nContent-Type: text/html; charset=utf-8\r\nContent-Length: ${bytes.size}\r\nConnection: close\r\n\r\n"
        output.write(header.toByteArray(StandardCharsets.UTF_8))
        output.write(bytes)
        output.flush()
    }

    private fun formPage(error: String = "") = """
        <!doctype html>
        <html lang="en">
        <head>
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <title>Behroozuac V2ray</title>
          <style>
            body{font-family:Arial,sans-serif;background:#050708;color:#f3ffff;margin:0;padding:22px}
            h1{font-size:24px;margin:0 0 14px}
            textarea{box-sizing:border-box;width:100%;height:52vh;background:#101718;color:#fff;border:1px solid #28e6d6;border-radius:8px;padding:14px;font-size:15px}
            button{width:100%;height:52px;margin-top:14px;border:0;border-radius:8px;background:#28e6d6;color:#001313;font-size:18px;font-weight:700}
            p{color:#b7c9ca;line-height:1.45}
            .err{color:#ff4d7d}
          </style>
        </head>
        <body>
          <h1>Behroozuac V2ray</h1>
          <p>Paste one or more VLESS, Trojan, VMess, or subscription configs. Put each config on a new line.</p>
          ${if (error.isBlank()) "" else "<p class=\"err\">$error</p>"}
          <form method="post">
            <textarea name="configs" autofocus></textarea>
            <button type="submit">Add configs to TV</button>
          </form>
        </body>
        </html>
    """.trimIndent()

    private fun successPage() = """
        <!doctype html>
        <html lang="en">
        <head>
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <title>Behroozuac V2ray</title>
          <style>
            body{font-family:Arial,sans-serif;background:#050708;color:#f3ffff;margin:0;padding:28px;text-align:center}
            h1{font-size:24px;margin-top:22vh}
            a{color:#28e6d6}
          </style>
        </head>
        <body>
          <h1>Configs sent to TV</h1>
          <p>You can return to the TV now.</p>
          <p><a href="/">Add more configs</a></p>
        </body>
        </html>
    """.trimIndent()

    private fun findLocalIpv4(): String? {
        return NetworkInterface.getNetworkInterfaces().asSequence()
            .filter { it.isUp && !it.isLoopback }
            .flatMap { it.inetAddresses.asSequence() }
            .filterIsInstance<Inet4Address>()
            .mapNotNull { it.hostAddress }
            .firstOrNull { it.startsWith("192.168.") || it.startsWith("10.") || it.matches(Regex("172\\.(1[6-9]|2\\d|3[0-1])\\..+")) }
    }
}
