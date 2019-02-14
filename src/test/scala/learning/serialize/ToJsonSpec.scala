package learning.serialize

import com.github.nscala_time.time.Imports.DateTime
import net.liftweb.json.{DefaultFormats, Serialization}
import org.scalatest.FunSuite

class ToJsonSpec extends FunSuite {

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

  test("You can specify the date format") {
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
}
