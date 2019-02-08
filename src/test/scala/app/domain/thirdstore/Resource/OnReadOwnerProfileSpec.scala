package test.app.domain.thirdstore.Resource

import builders.BuildResource
import builders.authorizes.BuildScope
import org.scalatest.FunSuite
import org.scalatest.Matchers._

class OnReadOwnerProfileSpec extends FunSuite{

  test("Can read data when allowed and token is live") {
    val givenResource = BuildResource.withLiveToken(
      withsurname = "my surname",
      withScope = Option(BuildScope.onlySurname())
    )

    assert(givenResource.surname() === "my surname")
  }

  test("Exceptions when reading not-authorised data") {
    val givenResource = BuildResource.withLiveToken(
      withScope = Option(BuildScope.onlyEmailAndFirstname())
    )

    the [IllegalAccessException] thrownBy(
      givenResource.surname()
      ) should have message "The scope doesn't allow you to access to surname"
  }

  test("Even if the scope allows it, if the token is expired then the profile cannot be read") {
    val givenResource = BuildResource.withExpiredToken(
      withScope = Option(BuildScope.onlySurname())
    )

    the [IllegalAccessException] thrownBy(
      givenResource.surname()
    ) should have message "The scope allows to access this property. However your token is expired and need to be refreshed"
  }

  test("Even if the scope allows it, if the token doesn't exist or was revoked then an exception is triggered") {
    val givenResource = BuildResource.withoutToken(
      withScope = Option(BuildScope.onlySurname())
    )

    the [IllegalAccessException] thrownBy(
      givenResource.surname()
    ) should have message "There is no token. Cannot be possible to know if is expired."
  }
}
