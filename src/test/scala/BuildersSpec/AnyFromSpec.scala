package BuildersSpec

import builders.AnyFrom
import org.scalatest.FunSuite

class AnyFromSpec extends FunSuite {
  // TODO: test a trait that select randomly elements from a Seq
  // TODO: put in another trait the random-string-generator
  test("I can use apply() to speed up process when coding") {


    val one = AnyFrom("aa", "bb", "cc", "dd", "ee")
    val two = AnyFrom("aa", "bb", "cc", "dd", "ee")
    val three = AnyFrom("aa", "bb", "cc", "dd", "ee")

    assert(one !== two !== three, "=> Should be random (they might match also sometimes...because of that is random)")
    assert(one.isInstanceOf[String] && two.isInstanceOf[String] && three.isInstanceOf[String])
  }

  test("I can generate random strings") {


    val one = AnyFrom.text()
    val two = AnyFrom.text()
    val three = AnyFrom.text()

    assert(one !== two !== three)
    assert(one.isInstanceOf[String] && two.isInstanceOf[String] && three.isInstanceOf[String])
  }
}
