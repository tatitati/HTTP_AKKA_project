package learning

import org.scalatest.FunSuite
import scala.util.matching.Regex

class RegexSpec extends FunSuite {

  test("I can match a simple regex expression") {
    val numberPattern: Regex = "[0-9]".r

    assert(numberPattern.findFirstIn("awesomepassword") === None)
  }

  test("I can test more complex expressions") {
    val numberPattern: Regex = "[0-9a-zA-Z_+#-=:.()]".r

    assert(numberPattern.findFirstIn("awesomepassword").isInstanceOf[Some[_]])
    assert(numberPattern.findFirstIn("+pas:=sw.ord").isInstanceOf[Some[_]])
  }
}
