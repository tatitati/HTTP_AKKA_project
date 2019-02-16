package learning.serialize

import com.github.nscala_time.time.Imports.DateTime
import net.liftweb.json.Serialization.write
import net.liftweb.json._
import org.scalatest.FunSuite

class ToJsonSpec extends FunSuite {


  test("Dates are not converted when serializing by default") {
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

  test("You can specify keys and formats of every value if you wish") {
    val givenMap = Map(
      "access_token" -> "whatever",
      "refresh_token" -> 5,
      "token_type" -> DateTime.now().toString("==YYYY=="),
    )

    val mapSerialized = Serialization.write(givenMap)(DefaultFormats)

    assert(mapSerialized ===
      """{
        |"access_token":"whatever",
        |"refresh_token":5,
        |"token_type":"==2019=="
        |}""".stripMargin.replaceAll("\n", ""))
  }

  test("I can convert to json an object using lift-json") {
    class GivenClass(val name: String, val age: Int)
    implicit val formats = Serialization.formats(NoTypeHints)
    val jsonString = write(new GivenClass("francisco", 34))

    assert(jsonString === """{"name":"francisco","age":34}""")
  }
}
