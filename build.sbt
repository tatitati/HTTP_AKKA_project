name := "akka-quickstart-scala"

version := "1.0"

scalaVersion := "2.12.6"

lazy val akkaVersion = "2.5.20"

val lift_json = "net.liftweb" %% "lift-json" % "2.5+"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % "2.5.20",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-http"   % "10.1.7",
  "com.typesafe.akka" %% "akka-stream" % "2.5.19",
  "com.github.nscala-time" %% "nscala-time" % "2.20.0",

  // test
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test
)
