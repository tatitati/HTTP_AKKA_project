package BuildersSpec

import builders.Randomizer
import org.scalatest.FunSuite

class RandomizerSpec extends FunSuite {
  // TODO: test a trait that select randomly elements from a Seq
  // TODO: put in another trait the random-string-generator

  test("I can choost randomly an element from a Seq") {
    val items = Vector("aa", "bb", "cc", "dd", "ee")

    val one = Randomizer.any(items)
    val two = Randomizer.any(items)
    val three = Randomizer.any(items)

    assert(one !== two !== three, "=> Should be random (they might match also sometimes...because of that is random)")
    assert(one.isInstanceOf[String] && two.isInstanceOf[String] && three.isInstanceOf[String])


  }
}
