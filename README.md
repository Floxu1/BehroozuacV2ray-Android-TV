<div dir="rtl" align="right">



# BehroozuacV2ray Android TV

**Behroozuac V2ray** نسخه مخصوص Android TV پروژه v2rayNG است؛ با پکیج:

`com.behroozuac.v2raytv`

این نسخه برای استفاده روی تلویزیون، کنترل تلویزیون و نصب راحت‌تر روی Android TV آماده شده است.

[کانال تلگرام](https://t.me/UacSniSpoofer): `t.me/UacSniSpoofer`

---

## ویژگی مهم برنامه: افزودن کانفیگ با موبایل

یکی از مهم‌ترین قابلیت‌های این برنامه، **Add configs by phone** است.

در تلویزیون یک QR Code نمایش داده می‌شود. کاربر با موبایل آن را اسکن می‌کند، وارد یک صفحه وب محلی می‌شود، کانفیگ‌ها را داخل فرم قرار می‌دهد و با ارسال فرم، کانفیگ‌ها مستقیم داخل برنامه Android TV اضافه می‌شوند.

این قابلیت برای Android TV بسیار کاربردی است، چون کاربر مجبور نیست لینک‌های طولانی V2Ray را با ریموت کنترل تایپ کند.
نکته : اگر از قابلیت Add configs by phone میخواین استفاده کنید باید موبایل و تلویزیون شما به یک وای فای متصل باشن.

<div align="center">
  <img src="https://github.com/user-attachments/assets/4cab6e9f-9b83-46ba-8a81-eb5ce49bbeae" height="320" />
  <img src="https://github.com/user-attachments/assets/e418a815-1c6e-41b7-8922-f62c3711c376" height="320" />
  <img src="https://github.com/user-attachments/assets/bc7687f1-0a68-4f30-adc3-96d4697b9719" height="320" />
  <img src="https://github.com/user-attachments/assets/63d39cd1-c896-4309-9788-1be6877d1d72" height="320" />
</div>


---

## قابلیت‌ها

- رابط کاربری Dark/Neon مخصوص Android TV
- آیتم‌های بزرگ‌تر برای استفاده راحت‌تر با کنترل تلویزیون
- Focus state واضح برای حرکت با دکمه‌های ریموت
- دکمه Connect ابتدا از همه کانفیگ‌ها real ping می‌گیرد
- اتصال خودکار به کمترین delay
- اتصال مستقیم با کلیک روی هر کانفیگ
- افزودن کانفیگ از طریق موبایل با QR Code
- بدون کانفیگ داخلی در نسخه اوپن‌سورس
- غیرفعال بودن HEV TUN به‌صورت پیش‌فرض برای جلوگیری از crash هنگام نبود `libhev-socks5-tunnel.so`
- استفاده از `libv2ray.aar` رسمی AndroidLibXrayLite داخل مسیر `V2rayNG/app/libs`


<img width="1909" height="1083" alt="Screenshot 2026-06-08 050719" src="https://github.com/user-attachments/assets/d2d6646d-a1bc-459c-a181-14447c3f0d74" />

---

## کانفیگ‌های پیش‌فرض

این نسخه عمومی هیچ کانفیگ داخلی یا پیش‌فرضی ندارد.

کاربر باید کانفیگ‌های خودش را از یکی از روش‌های زیر اضافه کند:

- Add configs by phone
- QR Code
- Clipboard
- فایل local
- Subscription
- ورود دستی

---

## دانلود APK

نسخه پیشنهادی برای Android TV 11:

[BehroozuacV2ray-TV-ARMEABI-V7A-1.0.5.apk](https://release-assets.githubusercontent.com/github-production-release-asset/1262438713/06c6bbf1-4821-4ddf-a10d-587a7e53e098?sp=r&sv=2018-11-09&sr=b&spr=https&se=2026-06-08T03%3A07%3A17Z&rscd=attachment%3B+filename%3DBehroozuacV2ray-TV-ARMEABI-V7A-1.0.5.apk&rsct=application%2Fvnd.android.package-archive&skoid=96c2d410-5711-43a1-aedd-ab1947aa7ab0&sktid=398a6654-997b-47e9-b12b-9515b896b4de&skt=2026-06-08T02%3A06%3A37Z&ske=2026-06-08T03%3A07%3A17Z&sks=b&skv=2018-11-09&sig=jdCv%2BNFuxVjtP83SjAsPQJ%2F3huDuuJ3YcCOD51soZGc%3D&jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmVsZWFzZS1hc3NldHMuZ2l0aHVidXNlcmNvbnRlbnQuY29tIiwia2V5Ijoia2V5MSIsImV4cCI6MTc4MDg4NjkxNSwibmJmIjoxNzgwODg1MTE1LCJwYXRoIjoicmVsZWFzZWFzc2V0cHJvZHVjdGlvbi5ibG9iLmNvcmUud2luZG93cy5uZXQifQ.3nAglH8JmC9aRanSGUpk1JUDZz9yGe587R_Csog-jcw&response-content-disposition=attachment%3B%20filename%3DBehroozuacV2ray-TV-ARMEABI-V7A-1.0.5.apk&response-content-type=application%2Fvnd.android.package-archive)

این نسخه ARMEABI-V7A برای نصب روی Android TV 11 سازگاری بهتری دارد. اگر هنگام نصب پیام `App not installed` دریافت کردید، می‌توانید نسخه‌های دیگر را هم تست کنید:

- `BehroozuacV2ray-TV-ARM64-V8A-1.0.5.apk`
- `BehroozuacV2ray-TV-ARMEABI-V7A-1.0.5.apk`
- `BehroozuacV2ray-TV-X86-1.0.5.apk`
- `BehroozuacV2ray-TV-X86_64-1.0.5.apk`
- `BehroozuacV2ray-TV-UNIVERSAL-1.0.5`

---

## بیلد پروژه

پروژه Android داخل پوشه `V2rayNG` قرار دارد و می‌توانید آن را با Android Studio باز کنید.

برای بیلد از Gradle:

```powershell
cd V2rayNG
.\gradlew.bat assemblePlaystoreRelease
```

اطلاعات امضای release باید در فایل محلی و ignore شده `signing.properties` یا از طریق environment variable تنظیم شود:

```properties
storeFile=keystore/your-release-key.jks
storePassword=...
keyAlias=...
keyPassword=...
```

کلید امضا، keystore و پسوردها را داخل GitHub قرار ندهید.

---

## لایسنس و حقوق

این پروژه تحت لایسنس **GPL-3.0** منتشر شده است.

Copyright (C) 2026 Behroozuac

شما می‌توانید پروژه را ادامه دهید، تغییر دهید و ارتقا بدهید؛ اما باید لایسنس GPL-3.0، نام منبع و حقوق سازنده اصلی حفظ شود. حذف نام منبع، حذف copyright notice یا معرفی پروژه اصلی به نام خودتان مجاز نیست.

</div>

---

<div dir="ltr" align="left">

# BehroozuacV2ray Android TV

**Behroozuac V2ray** is an Android TV build based on v2rayNG, packaged as:

`com.behroozuac.v2raytv`

It is tuned for TV screens, TV remote navigation, and easier installation on Android TV devices.

Telegram channel: [t.me/UacSniSpoofer](https://t.me/UacSniSpoofer)

---

## Key Feature: Add Configs by Phone

The strongest feature of this app is **Add configs by phone**.

The TV shows a QR code. The user scans it with a phone, opens a local web page, pastes configs into the form, and submits them directly into the Android TV app.

This is especially useful on Android TV because users do not need to type long V2Ray config links with a remote control.

---

## Features

- Dark/neon Android TV interface
- Larger list rows for remote-control use
- Clear focus states for D-pad navigation
- Connect button runs real ping across imported configs first
- Automatically connects to the lowest-delay config
- Clicking a config connects that exact config
- Add configs from a phone using QR code
- No built-in configs in the open-source build
- HEV TUN is disabled by default to avoid crashes when `libhev-socks5-tunnel.so` is not bundled
- Uses the official AndroidLibXrayLite `libv2ray.aar` in `V2rayNG/app/libs`

---

## Built-In Configs

This public build contains no internal/default proxy configs.

Users must add their own configs through:

- Add configs by phone
- QR code
- Clipboard
- Local file
- Subscription
- Manual entry

---

## APK Downloads

Recommended build for Android TV 11:

`BehroozuacV2ray-TV-UNIVERSAL-1.0.5.apk`

This Universal version has better install compatibility on Android TV 11. If Android shows `App not installed`, try one of the ABI-specific builds:

- `BehroozuacV2ray-TV-ARM64-V8A-1.0.5.apk`
- `BehroozuacV2ray-TV-ARMEABI-V7A-1.0.5.apk`
- `BehroozuacV2ray-TV-X86-1.0.5.apk`
- `BehroozuacV2ray-TV-X86_64-1.0.5.apk`

---

## Build

The Android project is inside the `V2rayNG` folder. Open it with Android Studio or build with Gradle:

```powershell
cd V2rayNG
.\gradlew.bat assemblePlaystoreRelease
```

Release signing must be configured through an ignored local `signing.properties` file or environment variables:

```properties
storeFile=keystore/your-release-key.jks
storePassword=...
keyAlias=...
keyPassword=...
```

Do not commit release keystores or signing passwords to GitHub.

---

## License and Rights

This project is released under **GPL-3.0**.

Copyright (C) 2026 Behroozuac

You may continue, modify, and improve the project under the GPL-3.0 terms, but you must preserve the license, source attribution, and original copyright notices. Do not remove attribution or present the original work as your own.

</div>
