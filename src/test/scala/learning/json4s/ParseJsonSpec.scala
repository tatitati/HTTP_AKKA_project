//package learning.serialize
//
//import org.scalatest.FunSuite
//import scala.util.parsing.json._
//import org.json4s._
//import org.json4s.JsonDSL._
//import org.json4s.jackson.JsonMethods._
//
//class ParseJsonSpec extends FunSuite {
//
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
//
////  test("Another way") {
////    val givenJson = """
////                   {
////                      "access_token":"whatever",
////                      "refresh_token":5
////                    }
////                    """
////
////
////
////    assert(extracted === Some(Map("access_token" -> "whatever", "refresh_token" -> 5.0)))
////  }
//}
