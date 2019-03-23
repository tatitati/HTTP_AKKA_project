package test.app.domain.model.auth

import org.scalatest.FunSuite

class AuthSpec extends FunSuite {

  test("Report what permissions were granted to a third") {
    val givenAuth = BuildAuth.any(
      withScope = BuildScope.onlySurname()
    )

    assert(givenAuth.canReadFirstname === false)
    assert(givenAuth.canReadSurname === true)
  }

  test("I can compare two Auths by identity") {
    val givenAuth1 = BuildAuth.any(withId = BuildAuthId.any1())
    val givenAuth2 = BuildAuth.any(withId = BuildAuthId.any2())
    val givenAuth3 = BuildAuth.any(withId = BuildAuthId.any2())

    assert(givenAuth1.equals(givenAuth2) === false)
    assert(givenAuth2.equals(givenAuth3) === true)
  }
}
