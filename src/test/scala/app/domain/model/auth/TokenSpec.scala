package app.domain.model.auth

import test.builders.BuildUuid
import org.scalatest.FunSuite

class TokenSpec extends FunSuite{

  test("Know if a token is live") {
    val givenLiveToken = BuildToken.anyLive()
    val givenExpiredToken = BuildToken.anyExpired()

    assert(givenLiveToken.isLive === false)
    assert(givenExpiredToken.isLive === true)
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
