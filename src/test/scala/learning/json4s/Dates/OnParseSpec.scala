package test.learning.json4s.Dates

import org.scalatest.FunSuite
import org.joda.time.DateTime
import org.json4s._
import org.json4s.jackson.JsonMethods.{compact, parse, render}
import org.json4s.native.Serialization
import org.json4s.native.Serialization.read

class OnParseSpec extends FunSuite {

  implicit val formats = DefaultFormats
  class GivenClassWithDate(val firstName: String, val date: DateTime)
  val jsonWithDate = """{"firstName":"francisco","datetime":"2030-02-20T13:08:20.020Z"}"""

  test("Dates are parsed as string") {
    val parsed = parse(jsonWithDate)

    val parsedDate = parsed \\ "datetime"

    assert(parsedDate === JString("2030-02-20T13:08:20.020Z"))
  }

  test("Can obtain DateTime from an string") {
    val parsed = parse(jsonWithDate)

    val value = (parsed \\ "datetime").extract[String]
    val converted = new DateTime(value)

    assert(converted.toString() === "2030-02-20T13:08:20.020Z")
  }
}
