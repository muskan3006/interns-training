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
libraryDependencies +="org.scalatest" %% "scalatest" % "3.2.15" % Test



libraryDependencies += "org.apache.pdfbox" % "pdfbox" % "2.0.28"
libraryDependencies += "org.apache.poi" % "poi-ooxml" % "5.2.3"
libraryDependencies += "org.apache.pdfbox" % "pdfbox" % "2.0.28"
libraryDependencies += "fr.opensagres.xdocreport" % "fr.opensagres.poi.xwpf.converter.pdf" % "2.0.4"
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.20.0"


