package learning

import com.github.nscala_time.time.Imports.DateTime
import net.liftweb.json._
import net.liftweb.json.{DefaultFormats, Serialization, parse}
import org.scalatest.FunSuite
import com.github.nscala_time.time.Imports._

class SerializeSpec extends FunSuite {
  implicit val formats = DefaultFormats

  test("Dates are not converted when serializing") {
      val givenMap = Map(
        "access_token" -> "whatever",
        "refresh_token" -> 5,
        "token_type" -> DateTime.now(),
      )

      val mapSerialized = Serialization.write(givenMap)(DefaultFormats)

      assert(mapSerialized ===
        """{
          |"access_token":"whatever",
          |"refresh_token":5,
          |"token_type":{}
          |}""".stripMargin.replaceAll("\n", ""))
  }


  test("Can do some basic de-serialization from json") {
    val givenJson = """{
                      |"access_token":"whatever",
                      |"refresh_token":5
                      |}""".stripMargin.replaceAll("\n", "")
    
    val extracted = parse(givenJson).extract[Map[String, String]]

    assert(extracted === Map("access_token" -> "whatever", "refresh_token" -> "5"))
    assert(extracted("access_token") == "whatever")
    assert(extracted("refresh_token") == "5")
  }
}
