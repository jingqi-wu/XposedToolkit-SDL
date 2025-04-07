![Github Actions Build Status](https://github.com/smartdevicelink/sdl_core/actions/workflows/sdl_core_github_ci.yml/badge.svg)  

# XposedToolkit-SDL
An Xposed based App that support several SDL App. Hooking API, network and location for security test. Most work on Glympse, could modify the location and send fake location via bluetooth.

# Environment
openjdk version "1.8.0_442"  
Gradle 8.3

# How to run
Connect rooted phone(My type is Motorola Nexus 6), make sure you turn on the USB test.  
Then run:  
```
adb devices
adb logcat | grep Glympse
```
For all xposed App:  
```
adb logcat | grep xposed  
```
If your device could not activate adb connection, run:  
```
rm -rf ~/.android/adbkey*
```
Then plug it again, until you see the adb devices.
