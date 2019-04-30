import sbt.Keys.parallelExecution
import Dependencies._
import CommonSettings._


val sayHello = taskKey[Unit]("A simple task")


lazy val infrastructure = (project in file("infrastructure"))
  .dependsOn(domain)
  .settings(
    name := "infrastructure",
    commonsSettings,
    libraryDependencies ++= thirdDependencies,
    sayHello := {
      println("INFRASTRUCTURE: pong")
    }
  )

lazy val domain = (project in file("domain"))
  .dependsOn(root)
  .settings(
    name := "domain",
    commonsSettings,
    libraryDependencies ++= thirdDependencies,
    sayHello := {
      println("DOMAIN: pong")
    }
  )

lazy val root = (project in file("."))
  .settings(
    name := "root",
    commonsSettings,
    libraryDependencies ++= thirdDependencies,
    sayHello := {
      println("ROOT: pong")
    }
  )



parallelExecution in Test := false


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
