name := "akka-quickstart-scala"

version := "1.0"

scalaVersion := "2.12.6"

val akkaVersion = "2.5.17"

val akkaHttpVersion = "10.1.7"

libraryDependencies ++= Seq(

  // prod
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.github.nscala-time" %% "nscala-time" % "2.20.0",
  "org.json4s" %% "json4s-native" % "3.6.4",
  "org.json4s" %% "json4s-jackson" % "3.6.4",

  // dev
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
)