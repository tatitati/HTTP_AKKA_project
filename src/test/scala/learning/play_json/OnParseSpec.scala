package learning.play_json

import org.scalatest.FunSuite
import play.api.libs.json.{JsValue, Json}

class OnParseSpec extends FunSuite {

  test("Parse return a JsValue") {
    val json: JsValue = Json.parse("""
      {
        "firstName": "francisco",
        "mydatetime": "2030-02-20T13:08:20.020Z"
      }
      """)

    assert(json.isInstanceOf[JsValue])
  }

  test("I can extract some more JsValues") {
    val json: JsValue = Json.parse("""
      {
        "firstName": "francisco",
        "mydatetime": "2030-02-20T13:08:20.020Z"
      }
      """)

    val extracted = (json \ "mydatetime").get

    assert(extracted.isInstanceOf[JsValue])
  }

  test("I can extract the raw value of a JsValue") {
    val json: JsValue = Json.parse("""
      {
        "firstName": "francisco",
        "mydatetime": "2030-02-20T13:08:20.020Z"
      }
      """)

    val extracted = (json \ "mydatetime").get

    assert(extracted.toString() === "\"2030-02-20T13:08:20.020Z\"")
    assert((json \ "mydatetime").as[String] === "2030-02-20T13:08:20.020Z")
  }
}
