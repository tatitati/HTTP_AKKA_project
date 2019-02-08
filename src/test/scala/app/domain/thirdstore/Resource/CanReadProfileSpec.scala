package test.app.domain.thirdstore.Resource

import builders.BuildResource
import builders.authorizes.BuildScope
import org.scalatest.FunSuite

class CanReadProfileSpec extends FunSuite{

  test("Can read data when allowed and token is live") {
    val givenResource = BuildResource.withLiveToken(
      withsurname = "my surname",
      withScope = Option(BuildScope.onlySurname())
    )

    assert(givenResource.surname() === "my surname")
  }

  test("Exceptions are rised when a third try to read a field that is not allowed") {
    val givenResource = BuildResource.withLiveToken(
      withScope = Option(BuildScope.onlyEmailAndFirstname())
    )

    assertThrows[IllegalAccessException] {
      givenResource.surname()
    }
  }

  test("Even if the scope allows it, if the token is expired then the profile cannot be read") {
    val givenResource = BuildResource.withExpiredToken(
      withsurname = "my surname",
      withScope = Option(BuildScope.onlySurname())
    )

    assertThrows[IllegalAccessException] {
      givenResource.surname()
    }
  }
}
