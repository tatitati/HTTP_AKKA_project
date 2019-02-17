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
  class GivenClass(val name: String, val age: Int)

  test("Can serialize flat structures") {
      val givenMap = ("user" -> "whatever") ~ ("refresh_token" -> 5)
      val rendered = render(givenMap)

      assert(rendered === JObject(List(
        ("user",JString("whatever")),
        ("refresh_token",JInt(5)))
      ))

      val compacted = compact(render(givenMap))
      assert(compacted ===
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

  test("I can a custom class into json") {
    implicit val formats = Serialization.formats(NoTypeHints)

    val instalcne = new GivenClass("francisco", 34)
    val jsonString = write(instalcne)

    assert(jsonString === """{"name":"francisco","age":34}""")
  }
}
