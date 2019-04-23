package test.app.domain.model.thirdapp

import org.scalatest.FunSuite

class SiteSpec extends FunSuite {

  test("App can refresh credentials") {
      val givenApp = BuildSite.any()

      val originalCredentials = givenApp.getCredentials
      givenApp.refreshCredentials()
      val newCredentials = givenApp.getCredentials

      assert(originalCredentials.equals(newCredentials) === false)
  }

  test("Can update the name of the app") {
    val givenApp = BuildSite.any()

    givenApp.updateName("new name")
    givenApp.updateDescription("new description")

    assert(givenApp.getProfile.name === "new name")
    assert(givenApp.getProfile.description === "new description")
  }
}
