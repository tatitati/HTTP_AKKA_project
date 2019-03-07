package test.app.domain.resource.ResourceByToken

import builders.authorizes.BuildScope
import org.scalatest.FunSuite
import org.scalatest.Matchers._
import test.builders.BuildResourceByToken

class ContainsOwnerProfileSpec extends FunSuite{

  test("Can read data when allowed and token is live") {
    val givenResource = BuildResourceByToken.withLiveToken(
      withsurname = "my surname",
      withScope = Option(BuildScope.onlySurname())
    )

    assert(givenResource.surname() === "my surname")
  }

  test("Exceptions when reading not-authorised data") {
    val givenResource = BuildResourceByToken.withLiveToken(
      withScope = Option(BuildScope.onlyEmailAndFirstname())
    )

    the [IllegalAccessException] thrownBy(
      givenResource.surname()
      ) should have message "The scope doesn't allow you to access to surname"
  }

  test("Even if the scope allows it, if the token is expired then the profile cannot be read") {
    val givenResource = BuildResourceByToken.withExpiredToken(
      withScope = Option(BuildScope.onlySurname())
    )

    the [IllegalAccessException] thrownBy(
      givenResource.surname()
    ) should have message "The scope allows to access this property. However your token is expired and need to be refreshed"
  }
}
