package app.domain.thirdstore.third

import app.domain.thirdstore.RandomTextGenerator
import org.scalatest.FunSuite

class RandomTextGeneratorSpec extends FunSuite with RandomTextGenerator {
  test("I can test a trait that generate random text") {
    assert(generateRandomString() !== generateRandomString() )
  }
}
