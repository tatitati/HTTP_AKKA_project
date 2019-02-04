package learning

import org.scalatest.FunSuite

import scala.util.Random

class RandomStringGeneratorSpec extends FunSuite {
    test("can generate random string with an specific length") {

        val text1 = generateRandomText()
        val text2 = generateRandomText()

        assert(text1.isInstanceOf[String])
        assert(text1.size === 10)
        assert(text1 !== text2)
    }

    private def generateRandomText(): String = {
      val length = 10
      var text: String = ""

      for(a <- 1 to length) {
        text = text + Random.nextPrintableChar
      }

      text
    }
}
