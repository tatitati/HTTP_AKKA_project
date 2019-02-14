package app.infrastructure.serializer

import org.scalatest.FunSuite
import test.builders.BuildThirdProfile

class SerializerThirdProfileSpec extends FunSuite {

  test("Can serialize to json a ThirdProfileObject. THE ORDER OF THE MAP DOESNT FORCE THE SAME ORDER IN TO THE JSON!!") {
      val thirdprofile = BuildThirdProfile.any(
        withName = "any name",
        withCallback = "this is the callback",
        withClientid = "any clientid",
        withClientsecret = "one clientsecret",
        withDescription = "boring description here",
        withHomepage = "a homepage"
      )

      val inJson = SerializerThirdProfile.toJson(thirdprofile)

      assert(inJson ===
        """{
          |"name":"any name",
          |"description":"boring description here",
          |"callback":"this is the callback",
          |"clientsecret":"one clientsecret",
          |"clientid":"any clientid",
          |"homepage":"a homepage"
          |}""".stripMargin.replaceAll("\n", ""))
  }

  test("can deserialize") {

    val givenJson = """{
                      |"name":"any name",
                      |"description":"boring description here",
                      |"callback":"this is the callback",
                      |"clientsecret":"one clientsecret",
                      |"clientid":"any clientid",
                      |"homepage":"a homepage"
                      |}""".stripMargin.replaceAll("\n", "")

    val thirdprofile = SerializerThirdProfile.fromJson(givenJson)

    val expectedThirdProfile = BuildThirdProfile.any(
      withName = "any name",
      withCallback = "this is the callback",
      withClientid = "any clientid",
      withClientsecret = "one clientsecret",
      withDescription = "boring description here",
      withHomepage = "a homepage"
    )

    assert(expectedThirdProfile == thirdprofile)

  }
}
