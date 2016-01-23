import android.Keys._
import sbt._
import Keys._

object Dependencies {

  lazy val resolverUrls =
    Seq(
      Resolver.mavenLocal,
      DefaultMavenRepository,
      "jcenter" at "http://jcenter.bintray.com",
      Resolver.defaultLocal
    )


  lazy val libs: Seq[sbt.Setting[_]] = Seq(
    resolvers ++= resolverUrls,

    libraryDependencies ++= Seq(
      "com.android.support" % "support-v4" % "23.1.1",
      "org.macroid" %% "macroid" % Versions.macroidVersion,
      "com.squareup.retrofit" % "retrofit" % "1.9.0" exclude("gson", "gson"),
      "com.squareup.okhttp" % "okhttp" % "2.3.0",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.5.0"
    ),

    fork in Test := true,
    libraryDependencies ++= Seq(
      "com.geteit" %% "robotest" % "0.12" % Test,
      "org.scalatest" %% "scalatest" % "2.2.5" % Test
    )

  )

}