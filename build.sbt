import sbt.Keys.parallelExecution
import Dependencies._
import CommonSettings._

lazy val root = (project in file("."))
  .settings(
    commonsSettings,
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
