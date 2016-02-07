## Description
A template for REST client implementation based on [retrofit](https://github.com/square/retrofit)

Ui layout is done with [Macroid](http://macroid.github.io/).

With [robolectric](robolectric.org) beeing used for tests.


## Usage
First you need to have g8 installed, see [readme](http://github.com/n8han/giter8#readme)

```
g8 aafa/rest-android-scala
cd <project name>
sbt run
```

`sbt run` will try to run an app on a device (actual or emulator), make sure you have some `adb devices` ready.

`sbt quickTest` will do quick tests with [robolectric](robolectric.org) setup on your regular JVM.

## What you will get
A simple client implementaion with one actual call to https://api.bitfinex.com/v1 REST API to demostrate how things work.
