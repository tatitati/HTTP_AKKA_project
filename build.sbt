name := "akka-quickstart-scala"

version := "1.0"

scalaVersion := "2.12.6"

val akkaVersion = "2.5.17"
val akkaHttpVersion = "10.1.7"

libraryDependencies ++= Seq(
  // akka
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,

  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,

  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,


  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,


  // others
  "com.github.nscala-time" %% "nscala-time" % "2.20.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,


)