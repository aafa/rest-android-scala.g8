[![Join the chat at https://gitter.im/aafa/rest-android-scala.g8](https://badges.gitter.im/aafa/rest-android-scala.g8.svg)](https://gitter.im/aafa/rest-android-scala.g8?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)


## Description

A template for Android REST client implementation based on [retrofit](https://github.com/square/retrofit)

## Inside 
- [android-sdk-plugin](https://github.com/pfn/android-sdk-plugin) 
- [Macroid](http://macroid.github.io/) for Ui layout 
- [Robolectric](robolectric.org) for tests


## Install
First you need to have g8 installed, see [readme](http://github.com/n8han/giter8#readme)
Then:
```
g8 aafa/rest-android-scala
cd <project name>
sbt run
```

## Usage
`sbt run` will try to run an app on a device (actual or emulator), make sure you have some `adb devices` ready.
`sbt quickTest` will do quick tests with [robolectric](robolectric.org) setup on your regular JVM.

You will get a simple client implementaion with one actual call to https://api.bitfinex.com/v1 REST API to demostrate how things works.
