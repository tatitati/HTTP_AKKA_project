package learning

import org.scalatest.FunSuite

class textSpec extends FunSuite {
  test("I can convert multiline to singleline") {
    val text ="""this
        |is
        |whatever""".stripMargin.replaceAll("\n", " ")


    assert(text === "this is whatever")
  }

  test("Without striping margins") {
    val text ="""this
                |is
                |whatever""".replaceAll("\n", " ")


    assert(text === "this                 |is                 |whatever")
  }

  test("Without using pipes") {
    val text ="""this
                is
                whatever""".stripMargin


    assert(text === "this\n                is\n                whatever")
  }


}
