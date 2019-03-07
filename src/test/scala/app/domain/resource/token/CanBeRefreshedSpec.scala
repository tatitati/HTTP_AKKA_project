package test.app.domain.token

import org.scalatest.FunSuite
import test.builders.{BuildToken, BuildUuid}

class CanBeRefreshedSpec extends FunSuite{
  test("Must be used the valid refresh_token and the token must be expired") {
    val rightRefreshToken = BuildUuid.uuidOne()
    val wrongRefreshToken = BuildUuid.uuidTwo()
    val expiredToken = BuildToken.anyExpired(
      withRefreshToken = rightRefreshToken
    )

    assert(expiredToken.canRefreshWithParams(rightRefreshToken, "refresh_token") === true)
  }

  test("cannot refresh token if using wrong parameters") {
    val rightRefreshToken = BuildUuid.uuidOne()
    val wrongRefreshToken = BuildUuid.uuidTwo()
    val expiredToken = BuildToken.anyExpired(
      withRefreshToken = rightRefreshToken
    )

    assert(expiredToken.canRefreshWithParams(wrongRefreshToken, "refresh_token") === false)
    assert(expiredToken.canRefreshWithParams(rightRefreshToken, "wrong_gran_type") === false)
  }
}