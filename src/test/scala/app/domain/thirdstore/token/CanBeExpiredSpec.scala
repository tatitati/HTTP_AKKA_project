package app.domain.thirdstore.token

import builders.BuildToken
import org.scalatest.FunSuite

class CanBeExpiredSpec extends FunSuite{

  test("Can check if a token is live") {
    val givenToken = BuildToken.anyLive()
    assert(givenToken.isExpired === false)
  }

  test("Can check if a token is expired") {
    val givenToken = BuildToken.anyExpired()
    assert(givenToken.isExpired === true)
  }
}
