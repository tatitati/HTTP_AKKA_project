package learning.play_json

import org.joda.time.DateTime
import org.scalatest.FunSuite
import play.api.libs.json.{JsValue, Json}

class RenderSpec extends FunSuite {

  class GivenClassWithDate(val firstName: String, val mydatetime: DateTime)

  val sample = new GivenClassWithDate(firstName = "francisco", mydatetime = new DateTime("2019-02-20T23:20:36.642Z"))


  val inJson: JsValue = Json.obj(
    "aname" -> sample.firstName,
    "onedate" -> sample.mydatetime.toString()
  )

  test("Compact") {
    assert(inJson.toString() === """{"aname":"francisco","onedate":"2019-02-20T23:20:36.642Z"}""")
    assert(Json.stringify(inJson) === """{"aname":"francisco","onedate":"2019-02-20T23:20:36.642Z"}""")
  }

  test("pretty print") {
    assert(Json.prettyPrint(inJson) ===
      """{
        |  "aname" : "francisco",
        |  "onedate" : "2019-02-20T23:20:36.642Z"
        |}""".stripMargin)

  }
}
