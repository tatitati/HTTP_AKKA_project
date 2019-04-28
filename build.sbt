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
    libraryDependencies ++= deps
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



//{
//  def groupByFirst(tests: Seq[TestDefinition]) =
//    tests groupBy (_.name(0)) map {
//      case (letter, tests) =>
//        val options = ForkOptions().withRunJVMOptions(Vector("-Dfirst.letter"+letter))
//        new Group(letter.toString, tests, SubProcess(options))
//    } toSeq
//
//  testGrouping in Test := groupByFirst( (definedTests in Test).value )
//}

//testDomain := {
//  (excludeFilter in unmanagedSources) ~= { _ ||
//      new FileFilter {
//        def accept(f: File) = f.getPath.containsSlice("/infrastructure/")
//      }
//    }
//  (testOnly in Test).toTask(s" *").value
//}
