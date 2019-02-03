package app.domain.thirdstore

import builders.BuilderToken
import org.scalatest.FunSuite

class TokenAccessSpec extends FunSuite{

  test("Can check if a token is live") {
    val token = BuilderToken.anyLive()
    assert(token.isExpired === false)
  }

  test("Can check if a token is expired") {
    val token = BuilderToken.anyExpired()
    assert(token.isExpired === true)
  }
}
