import sbt.Keys.parallelExecution
import complete.DefaultParsers._
import scala.sys.process._
import Dependencies._


val commonsSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.6"
)

val sayHello = taskKey[Unit]("A simple task")
val demo = inputKey[Unit]("A demo input task.")

lazy val infrastructure = (project in file("infrastructure"))
  .dependsOn(domain % "test->test;compile->compile")
  .settings(
    name := "infrastructure subproject",
    commonsSettings,
    libraryDependencies ++= thirdDependencies,
    parallelExecution in Test := false,
    // task
    sayHello := {
      println("INFRASTRUCTURE: pong")
    }
  )

lazy val domain = (project in file("domain"))
  .settings(
    name := "domain subproject",
    commonsSettings,
    libraryDependencies ++= thirdDependencies,
    // task
    sayHello := {
      println("DOMAIN: pong")
    }
  )

lazy val root = (project in file("."))
  .aggregate(domain,infrastructure)
  .settings(
    name := "root project",
    commonsSettings,
    libraryDependencies ++= thirdDependencies,
    sayHello := {
      println("ROOT: pong")
    }
  )