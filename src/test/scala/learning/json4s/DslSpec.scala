package learning.json4s

import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._
import org.scalatest.FunSuite

class DslSpec extends FunSuite {

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
}
