import sbt.Keys.{parallelExecution, version}
import Dependencies._

lazy val commonSettings = Seq(
  name := "akka-quickstart-scala",
  version := "1.0",
  scalaVersion := "2.12.6"
)

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    libraryDependencies ++= thirdDependencies
  )

parallelExecution in Test := false


//filter folder from test and compilation (improve development process as I can go layer by layer)
//excludeFilter in (unmanagedSources) ~= { _ ||
//  new FileFilter {
//    def accept(f: File) = f.getPath.containsSlice("/infrastructure/")
//  } }

val sayHello = taskKey[Unit]("A simple hello")

sayHello := {
  println("hello!!!")
}


//testDomain := {
//  (excludeFilter in unmanagedSources) ~= { _ ||
//      new FileFilter {
//        def accept(f: File) = f.getPath.containsSlice("/infrastructure/")
//      }
//    }
//  (testOnly in Test).toTask(s" *").value
//}
