import sbt.Keys.parallelExecution
import Dependencies._
import CommonSettings._


val sayHello = taskKey[Unit]("A simple hello")

lazy val root = (project in file("."))
  .settings(
    commonsSettings,
    libraryDependencies ++= thirdDependencies,
    sayHello := {
      println("hello!!!")
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
