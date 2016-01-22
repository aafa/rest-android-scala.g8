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

    libraryDependencies += "com.android.support" % "support-v4" % "23.1.1",
    libraryDependencies += "org.macroid" %% "macroid" % Versions.macroidVersion,
    libraryDependencies += "com.squareup.retrofit" % "retrofit" % "1.9.0" exclude("gson", "gson"),
    libraryDependencies += "com.squareup.okhttp" % "okhttp" % "2.3.0",
    libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.5.0"

  )

}