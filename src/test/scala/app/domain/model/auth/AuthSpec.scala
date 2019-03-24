package test.app.domain.model.auth

import app.domain.model.auth.BuildToken
import org.scalatest.FunSuite

class AuthSpec extends FunSuite {

  test("I can compare two Auths by identity") {
    val givenAuth1 = BuildAuth.any(withId = BuildAuthId.any1())
    val givenAuth2 = BuildAuth.any(withId = BuildAuthId.any2())
    val givenAuth3 = BuildAuth.any(withId = BuildAuthId.any2())

    assert(givenAuth1.equals(givenAuth2) === false)
    assert(givenAuth2.equals(givenAuth3) === true)
  }

  test("if live token, then the scope specify what can be accessed") {
    val givenAuth = BuildAuth.any(
      withScope = BuildScope.onlySurname(),
      withToken = BuildToken.anyLive()
    )

    assert(givenAuth.canReadFirstname === false)
    assert(givenAuth.canReadSurname === true)
  }

  test("If expired token, then nothing can be read") {
    val givenAuth = BuildAuth.any(
      withScope = BuildScope.onlySurname(),
      withToken = BuildToken.anyExpired()
    )

    assert(givenAuth.canReadFirstname === false)
    assert(givenAuth.canReadSurname === false)
  }
}
