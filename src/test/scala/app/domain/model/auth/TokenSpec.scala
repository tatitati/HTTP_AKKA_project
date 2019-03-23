package app.domain.model.auth

import builders.BuildUuid
import org.scalatest.FunSuite

class TokenSpec extends FunSuite{

  test("Know if a token is live") {
    val givenToken = BuildToken.anyLive()
    assert(givenToken.isExpired === false)
  }

  test("Know if a token is expired") {
    val givenToken = BuildToken.anyExpired()
    assert(givenToken.isExpired === true)
  }

  test("Can refresh if is expired and is used the correct refresh_token") {
    val rightRefreshToken = BuildUuid.uuidOne()
    val wrongRefreshToken = BuildUuid.uuidTwo()
    val expiredToken = BuildToken.anyExpired(
      withRefreshToken = rightRefreshToken
    )

    assert(expiredToken.canRefreshWithParams(rightRefreshToken, "refresh_token") === true)
  }

  test("Cannot refresh token if using wrong GRANT TYPE") {
    val rightRefreshToken = BuildUuid.uuidOne()
    val wrongRefreshToken = BuildUuid.uuidTwo()
    val expiredToken = BuildToken.anyExpired(
      withRefreshToken = rightRefreshToken
    )

    assert(expiredToken.canRefreshWithParams(wrongRefreshToken, "refresh_token") === false)
    assert(expiredToken.canRefreshWithParams(rightRefreshToken, "wrong_gran_type") === false)
  }
}
