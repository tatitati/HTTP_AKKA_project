import sbt.Keys.parallelExecution
import complete.DefaultParsers._
import Dependencies._


val commonsSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.6"
)

val sayHello = taskKey[Unit]("A simple task")
val demo = inputKey[Unit]("A demo input task.")

demo := {
  // get the result of parsing
  val args: Seq[String] = spaceDelimited("<arg>").parsed
  // Here, we also use the value of the `scalaVersion` setting
  println("The current Scala version is " + scalaVersion.value)
  println("The arguments to demo were:")
  args foreach println
}

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
    // input task

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


//filter folder from test and compilation (improve development process as I can go layer by layer)
//excludeFilter in (unmanagedSources) ~= { _ ||
//  new FileFilter {
//    def accept(f: File) = f.getPath.containsSlice("/infrastructure/")
//  } }