package learning.serialize

import com.github.nscala_time.time.Imports.DateTime
import net.liftweb.json.{DefaultFormats, Serialization, parse}
import org.scalatest.FunSuite
import spray.json._
import scala.util.parsing.json._

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

//  test("way 3 Can do some basic de-serialization from json") {
//    val givenJson = """{
//                      |"access_token":"whatever",
//                      |"refresh_token":5,
//                      |
//                      |}""".stripMargin.replaceAll("\n", "")
//
//    // convert a String to a JValue object
//    val jValue = parse(givenJson)
//
//    // create a MailServer object from the string
//    val mailServer = jValue.extract[MailServer]
//    println(mailServer.url)
//    println(extracted)
//  }
}
