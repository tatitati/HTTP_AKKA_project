package test.app.domain.auth

import app.domain.auth.BuildToken
import org.scalatest.FunSuite

class TokenOnExpirationSpec extends FunSuite{

  test("Know if a token is live") {
    val givenToken = BuildToken.anyLive()
    assert(givenToken.isExpired === false)
  }

  test("Know if a token is expired") {
    val givenToken = BuildToken.anyExpired()
    assert(givenToken.isExpired === true)
  }
}
