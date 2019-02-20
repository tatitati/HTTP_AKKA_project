package learning.play_json

import org.joda.time.DateTime
import org.scalatest.FunSuite
import play.api.libs.json.Json

class ToJsonSpec extends FunSuite {
  class GivenClassWithDate(val firstName: String, val mydatetime: DateTime)


  test("simple to json") {
    val sample = new GivenClassWithDate(firstName = "francisco", mydatetime = new DateTime())

    
  }

}
