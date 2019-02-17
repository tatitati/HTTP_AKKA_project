package learning.json4s

import com.github.nscala_time.time.Imports.DateTime
import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.JsonAST
import org.json4s.jackson.JsonMethods._
import org.scalatest.FunSuite
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}


class ToJsonSpec extends FunSuite {
  class GivenClass(val firstName: String, val age: Int)


  test("Render() gives me a JObject") {
    val givenMap = ("user" -> "whatever") ~ ("refresh_token" -> 5)

    val rendered = render(givenMap)

    assert(rendered === JObject(List(
      ("user",JString("whatever")),
      ("refresh_token",JInt(5)))
    ))
  }

  test("Can serialize flat structures") {
      val givenMap = ("user" -> "whatever") ~ ("refresh_token" -> 5)

      val jsonString = compact(render(givenMap))

      assert(jsonString ===
        """{
          |"user":"whatever",
          |"refresh_token":5
          |}""".stripMargin.replaceAll("\n", ""))
  }

  test("Can serialize nested structures") {
    val givenMap =
      (
        "user" ->
          ("name" -> "Francisco") ~
          ("surname" -> "any surname")
      ) ~
      (
        "address" ->
          ("street" -> "95 avenue")
      )

    val rendered =  compact(render(givenMap))

    assert(rendered ===
      """{
        |"user":{
          |"name":"Francisco",
          |"surname":"any surname"
        |},
        |"address":
          |{"street":"95 avenue"}
        |}""".stripMargin.replaceAll("\n", ""))

  }

  test("I can a custom class into json directly, but no controlling the keys used or the format") {
    implicit val formats = Serialization.formats(NoTypeHints)

    val instalcne = new GivenClass("francisco", 34)
    val jsonString = write(instalcne)

    assert(jsonString === """{"firstName":"francisco","age":34}""")
  }

  test("I can convert to json and use camel_names in the properties as well") {
    implicit val formats = Serialization.formats(NoTypeHints)

    val instalcne = new GivenClass("francisco", 34)

    val step1 = write(instalcne)
    assert(step1 === """{"firstName":"francisco","age":34}""")

    val step2 = parse(step1)
    assert(step2 === JObject(List(("firstName",JString("francisco")), ("age",JInt(34)))))

    val step3 = render(step2.snakizeKeys)
    assert(step3 === JObject(List(("first_name",JString("francisco")), ("age",JInt(34)))))

    val step4 = compact(step3)
    assert(step4 === """{"first_name":"francisco","age":34}""")
  }
}
