package app.domain.thirdstore.token

import builders.BuildToken
import org.scalatest.FunSuite

class CanBeExpiredSpec extends FunSuite{

  test("Can check if a token is live") {
    val token = BuildToken.anyLive()
    assert(token.isExpired === false)
  }

  test("Can check if a token is expired") {
    val token = BuildToken.anyExpired()
    assert(token.isExpired === true)
  }
}
