package learning.serialize

import com.github.nscala_time.time.Imports.DateTime
import net.liftweb.json.Serialization.write
import net.liftweb.json.{DefaultFormats, NoTypeHints, Serialization}
import org.scalatest.FunSuite
import test.builders.{BuildResourceByCode, BuildThirdProfile}
import Serialization.{read, write => swrite}

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

  test("I can convert to json an object using lift-json") {
    val thirdprofile = BuildThirdProfile.any(
      withName = "any name",
      withCallback = "this is the callback",
      withClientid = "any clientid",
      withClientsecret = "one clientsecret",
      withDescription = "boring description here",
      withHomepage = "a homepage"
    )

    implicit val formats = Serialization.formats(NoTypeHints)
    val jsonString = write(thirdprofile)
    
    assert(jsonString === """{"name":"any name","clientid":"any clientid","clientsecret":"one clientsecret","callback":"this is the callback","homepage":"a homepage","description":"boring description here"}""")
  }
}
