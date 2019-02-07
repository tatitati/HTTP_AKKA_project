package app.domain.ownerstore

import builders.{BuildThird, BuildThirdProfile}
import builders.authorizes.{BuildAuth, BuildScope}
import org.scalatest.FunSuite

class AuthSpec extends FunSuite {

  test("Can show scope granted to third") {
    val givenAuth = BuildAuth.any(
      withThirdProfile = BuildThirdProfile.any(),
      withScope = BuildScope.onlySurname()
    )

    assert(givenAuth.canFirstname() === false, "=> Third should be able to access to firstname")
    assert(givenAuth.canSurname() === true, "=> Third should be able to access to surname")
  }

  test("Can show data about third") {
    val givenAuth = BuildAuth.any(
        withThirdProfile = BuildThirdProfile.any(
          withName = "CircleCI",
          withHomepage = "http://www.whatever.com",
          withDescription = "any description"
        )
    )

    assert(givenAuth.name == "CircleCI")
    assert(givenAuth.homepage == "http://www.whatever.com")
    assert(givenAuth.description == "any description")
  }

  test("Auth can have a token (or not if it was revoked)") {
    val givenAuth = BuildAuth.any()
    givenAuth.isInstanceOf[Auth]
  }
}
