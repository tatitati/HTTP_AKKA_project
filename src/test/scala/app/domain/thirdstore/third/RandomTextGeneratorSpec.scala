package app.domain.thirdstore.third

import app.domain.thirdstore.RandomTextGenerator
import org.scalatest.FunSuite

class RandomTextGeneratorSpec extends FunSuite with RandomTextGenerator {
  test("I can test a trait that generate random text") {
    assert(generateRandomString() !== generateRandomString() )
  }

  test("By default I create texts with 10 characters") {
    assert(generateRandomString().length === 10)
  }

  test("I can generate random texts with an specific length") {
    assert(generateRandomString(length = 15).length === 15)
  }
}
