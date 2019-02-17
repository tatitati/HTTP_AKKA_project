package learning.serialize

import org.json4s._
import org.json4s.jackson.JsonMethods.parse
import org.scalatest.FunSuite
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}

class ParseJsonSpec extends FunSuite {
  class GivenClass(val firstName: String, val age: Int)

  test("Parse returns a JSobject") {
      implicit val formats = Serialization.formats(NoTypeHints)

      val jsonString = """{"firstName":"francisco","age":34}"""

      val parsed = parse(jsonString)

      assert(parsed === JObject(List(("firstName",JString("francisco")), ("age",JInt(34)))))
  }


  test("I can a custom class into json directly, but no controlling the keys used or the format") {
    implicit val formats = Serialization.formats(NoTypeHints)

    val givenExample = new GivenClass("francisco", 34)

    val parsed = Serialization.read[GivenClass]("""{"firstName":"francisco","age":34}""")

    assert(parsed.age === 34)
    assert(parsed.firstName === "francisco")
  }

//  test("Can parse a flat json") {
//    val givenJson = """
//                   {
//                      "user":"whatever",
//                      "refresh_token":5
//                    }
//                    """
//
//    val parsed = parse(givenJson)
//
//    assert(parsed ===
//      JObject(List(("user",JString("whatever")), ("refresh_token",JInt(5))))
//    )
//
//    assert(parsed.values ===
//      Map("user" -> "whatever", "refresh_token" -> 5)
//    )
//  }

//
//  test("after parsing, I can query some data") {
//    case class Person(firstname: String, age: Int)
//
//    json transformField {
//      case ("first-name", x) => ("firstname", x)
//    }
//
//    val value = for {
//      JObject(child) <- json
//      JField("refresh_token", JString(tokenValue))  <- child
//    } yield child
//
//    println(value)
//  }

//  test("Another way") {
//    val givenJson = """
//                   {
//                      "access_token":"whatever",
//                      "refresh_token":5
//                    }
//                    """
//
//
//
//    assert(extracted === Some(Map("access_token" -> "whatever", "refresh_token" -> 5.0)))
//  }
}
