name := "Scala"
version := "0.1"

scalaVersion := "3.0.0"

val CirceVersion = "0.14.1"
val ScalaCsvVersion = "1.3.8"
val LogbackVersion = "1.2.3"

libraryDependencies ++= List(
  "io.circe" %% "circe-core" % CirceVersion,
  "io.circe" %% "circe-generic" % CirceVersion,
  "io.circe" %% "circe-parser" % CirceVersion,
  "com.github.tototoshi" %% "scala-csv" % ScalaCsvVersion,
  "ch.qos.logback"  %  "logback-classic"     % LogbackVersion
)
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
