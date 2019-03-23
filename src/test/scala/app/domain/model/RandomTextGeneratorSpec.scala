package test.app.domain.thirdstore.third

import app.domain.model.RandomTextGenerator
import org.scalatest.FunSuite

class RandomTextGeneratorSpec extends FunSuite with RandomTextGenerator {
  test("I can test a trait that generate random text") {
    assert(makeRandomText() !== makeRandomText() )
  }

  test("By default I create texts with 10 characters") {
    assert(makeRandomText().length === 10)
  }

  test("I can generate random texts with an specific length") {
    assert(makeRandomText(length = 15).length === 15)
  }
}
