

object Settings {

  var debugBuild = false

  lazy val dexFiles: Seq[String] = io.Source.fromFile("core/main-dex-list.txt").getLines().toSeq

  lazy val apkExcludeStrings: Seq[String] = Seq(
    "META-INF/LICENSE.txt",
    "META-INF/LICENSE",
    "META-INF/NOTICE.txt",
    "META-INF/NOTICE",
    ".readme",
    "reference.conf"
  )

  lazy val proguardDebug = Seq(
    "-dontobfuscate",
    "-dontoptimize",
    "-dontpreverify"
  ) 

  lazy val proguardRelease = Seq(
    "-optimizations class/*,field/*,method/*,code/*",
    "-mergeinterfacesaggressively",
    "-optimizationpasses 3"
  ) 


  lazy val proguardCache = Seq(
  )
}
