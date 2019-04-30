import sbt.Keys.parallelExecution
import Dependencies._


val commonsSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.6"
)

val sayHello = taskKey[Unit]("A simple task")


lazy val infrastructure = (project in file("infrastructure"))
  .dependsOn(domain % "test->test;compile->compile")
  .settings(
    name := "infrastructure",
    commonsSettings,
    libraryDependencies ++= thirdDependencies,
    sayHello := {
      println("INFRASTRUCTURE: pong")
    },
    parallelExecution in Test := false
  )

lazy val domain = (project in file("domain"))
  .settings(
    name := "domain",
    commonsSettings,
    libraryDependencies ++= thirdDependencies,
    sayHello := {
      println("DOMAIN: pong")
    },
  )

lazy val root = (project in file("."))
  .aggregate(domain,infrastructure)
  .settings(
    name := "root",
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






//testDomain := {
//  (excludeFilter in unmanagedSources) ~= { _ ||
//      new FileFilter {
//        def accept(f: File) = f.getPath.containsSlice("/infrastructure/")
//      }
//    }
//  (testOnly in Test).toTask(s" *").value
//}
