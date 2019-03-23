package test.app.domain.auth

import org.scalatest.FunSuite

class AuthSpec extends FunSuite {

  test("User can know what permissions were granted to a third") {
    val givenAuth = BuildAuth.any(
      withScope = BuildScope.onlySurname()
    )

    assert(givenAuth.canReadFirstname === false)
    assert(givenAuth.canReadSurname === true)
  }

  test("I can compare two oauths") {
    val givenAuth1 = BuildAuth.any()
    val givenAuth2 = BuildAuth.any()

    assert(givenAuth1.equals(givenAuth2) === false)
  }

}
