package learning

import com.github.nscala_time.time.Imports.DateTime
import net.liftweb.json._
import net.liftweb.json.{DefaultFormats, Serialization, parse}
import org.scalatest.FunSuite
import com.github.nscala_time.time.Imports._

class SerializeSpec extends FunSuite {

  test("Can serialize (to json) an object, but days have some problems") {

      val serialize = Serialization.write(Map(
          "access_token" -> "whatever",
          "refresh_token" -> 5,
          "token_type" -> DateTime.now(),
        ))(DefaultFormats)


      assert(serialize === "{\"access_token\":\"whatever\",\"refresh_token\":5,\"token_type\":{}}")
  }


  test("Can serialize (to json) an object, but with date properly converted to string") {

    val givenDateTime = new DateTime()
      .withDate(2030, 8, 20)
      .withTime(13, 8, 20, 400)

    val serialize = Serialization.write(Map(
      "access_token" -> "whatever",
      "refresh_token" -> 5,
      "token_type" -> givenDateTime.toString,
    ))(DefaultFormats)

    assert(serialize === """{"access_token":"whatever","refresh_token":5,"token_type":"2030-08-20T13:08:20.400+01:00"}""")
  }

  test("Can de-serialize a json to some not useful strings....") {
    case class someclass(access_token: String, refresh_token: Int, token_type: DateTime)

    val expectedDateTime = new DateTime()
      .withDate(2030, 8, 20)
      .withTime(13, 8, 20, 400)

    val expectedObject = Map(
      "access_token" -> "whatever",
      "refresh_token" -> 5,
      "token_type" -> expectedDateTime,
    )

    val givenJson = """{"access_token":"whatever","refresh_token":5,"token_type":"2030-08-20T13:08:20.400+01:00"}"""

    val parsedObject = parse(givenJson)
    implicit val formats = DefaultFormats
    val extracted = parsedObject.extract[Map[String, String]]

    assert(extracted("access_token") == "whatever")
    assert(extracted("refresh_token") == "5")
    assert(extracted("token_type") == "2030-08-20T13:08:20.400+01:00")
  }

  test("Can de-serialize a json to a useful object") {
    case class someclass(access_token: String, refresh_token: Int, token_type: DateTime)

    val expectedDateTime = new DateTime()
      .withDate(2030, 8, 20)
      .withTime(13, 8, 20, 400)

    val expectedObject = Map(
      "access_token" -> "whatever",
      "refresh_token" -> 5,
      "token_type" -> expectedDateTime,
    )

    val givenJson = """{"access_token":"whatever","refresh_token":5,"token_type":"2030-08-20T13:08:20.400+01:00"}"""

    val parsedObject = parse(givenJson)

    implicit val formats = DefaultFormats
    //val extracted = parsedObject.extract[someclass]
    //println(extracted)
  }
}
