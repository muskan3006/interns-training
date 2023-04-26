ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "scala-practice",
    idePackagePrefix := Some("com.knoldus")
  )

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
  "ch.qos.logback" % "logback-classic" % "1.4.6"
)
libraryDependencies += "org.apache.pdfbox" % "pdfbox" % "2.0.27"
libraryDependencies += "org.apache.pdfbox" % "pdfbox" % "3.0.0-RC1"
libraryDependencies += "org.apache.poi" % "poi-ooxml" % "5.2.3"
libraryDependencies += "fr.opensagres.xdocreport" % "fr.opensagres.poi.xwpf.converter.pdf" % "2.0.4" excludeAll (
  ExclusionRule("org.apache.logging.log4j", "log4j-core"),
  ExclusionRule("org.apache.logging.log4j", "log4j-api")
)
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.20.0"

