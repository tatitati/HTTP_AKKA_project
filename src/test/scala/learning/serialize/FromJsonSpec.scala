package learning.serialize

import org.scalatest.FunSuite
import scala.util.parsing.json._
import net.liftweb.json._

class FromJsonSpec extends FunSuite {

  implicit val formats = DefaultFormats

  test("Can do some basic de-serialization from json") {
    val givenJson = """
                   {
                      "access_token":"whatever",
                      "refresh_token":5
                    }
                    """

    val extracted = parse(givenJson).extract[Map[String, String]]

    assert(extracted === Map("access_token" -> "whatever", "refresh_token" -> "5"))
    assert(extracted("access_token") == "whatever")
    assert(extracted("refresh_token") == "5")
  }

  test("Another way") {
    val givenJson = """
                   {
                      "access_token":"whatever",
                      "refresh_token":5
                    }
                    """

    val extracted = JSON.parseFull(givenJson)

    assert(extracted === Some(Map("access_token" -> "whatever", "refresh_token" -> 5.0)))
  }
}
