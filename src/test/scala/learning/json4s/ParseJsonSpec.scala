package learning.serialize

import java.util.Date

import org.json4s._
import org.json4s.jackson.JsonMethods.{compact, parse, render}
import org.scalatest.FunSuite
import org.json4s.native.Serialization
import org.json4s.native.Serialization.read
import com.github.nscala_time.time.Imports._

class ParseJsonSpec extends FunSuite {
  class GivenClass(val firstName: String, val age: Int)

  test("Parse returns a JSobject") {
      implicit val formats = Serialization.formats(NoTypeHints)

      val jsonString = """{"firstName":"francisco","age":34}"""

      val parsed = parse(jsonString)

      assert(parsed === JObject(List(("firstName",JString("francisco")), ("age",JInt(34)))))
  }

  test("Can Extract data from the JSobject") {
    implicit val formats = Serialization.formats(NoTypeHints)
    val jsonString = """{"firstName":"francisco","age":34}"""
    val parsed = parse(jsonString)

    val age = parsed \\ "age"

    assert(age === JInt(34))
    assert(age.values === 34)
  }

  test("Can transform fields") {
    implicit val formats = Serialization.formats(NoTypeHints)
    val jsonString = """{"firstName":"francisco","age":34}"""
    val parsed = parse(jsonString)

    assert(parsed === JObject(List(("firstName",JString("francisco")), ("age",JInt(34)))))

    val newparsed = parsed.transformField {
      case JField("firstName", JString(s)) => ("whatever", JString(s.toUpperCase))
    }

    assert(newparsed === JObject(List(("whatever",JString("FRANCISCO")), ("age",JInt(34)))))
  }

  test("Dates are parsed as string") {
    val jsonString = """{"firstName":"francisco","date":"2030-02-20T13:08:20.020Z"}"""
    val parsed = parse(jsonString)

    val parsedDate = parsed \\ "date"

    assert(parsedDate === JString("2030-02-20T13:08:20.020Z"))
  }

//  test("Can transform dates strings to Date") {
//    implicit val formats = Serialization.formats(NoTypeHints)
//    val jsonString = """{"firstName":"francisco","date":"2030-02-20T13:08:20.020Z"}"""
//    val parsed = parse(jsonString)
//
//    val parsedDate = (parsed \\ "date").extract[Date]
//
//    assert("Wed Feb 20 13:08:20 GMT 2030" === parsedDate.toString)
//  }

  test("Can transform dates strings to DateTime?????") {
    implicit val formats = Serialization.formats(NoTypeHints)

  }

  test("I can parse a custom class into json directly, but no controlling the keys used or the format") {
    implicit val formats = Serialization.formats(NoTypeHints)

    val givenExample = new GivenClass("francisco", 34)

    val parsed = read[GivenClass]("""{"firstName":"francisco","age":34}""")

    assert(parsed.age === 34)
    assert(parsed.firstName === "francisco")
  }

  test("I can re-format a json and format the resulting keys to be camel_case") {
    val givenJson = """{"firstName":"francisco","age":34}"""

    val step2 = parse(givenJson)
    assert(step2 === JObject(List(("firstName",JString("francisco")), ("age",JInt(34)))))

    val step3 = render(step2.snakizeKeys)
    assert(step3 === JObject(List(("first_name",JString("francisco")), ("age",JInt(34)))))

    val step4 = compact(step3)
    assert(step4 === """{"first_name":"francisco","age":34}""")
  }
}
