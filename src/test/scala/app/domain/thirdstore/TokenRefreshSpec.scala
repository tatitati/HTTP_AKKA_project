package app.domain.thirdstore

import java.util.UUID

import builders.BuilderToken
import org.scalatest.FunSuite

class TokenRefreshSpec extends FunSuite{
  test("Can know if can be refreshed when used the proper refresh token") {
    val refreshToken = UUID.fromString("aaaa-bbbb-cccc-dddd-eeee")
    val token = BuilderToken.anyLive(refreshToken = Option(refreshToken))

    assert(token.canRefreshWith(UUID.fromString("aaaa-bbbb-cccc-dddd-eeee"), "refresh_token") === true)
    assert(token.canRefreshWith(UUID.fromString("aaaa-eeea-aaaa-eeee-aaaa"), "refresh_token") === false)
  }

  test("Can know if can be refreshed when used the proper grant_type ") {
    val refreshToken = UUID.fromString("aaaa-bbbb-cccc-dddd-eeee")
    val token = BuilderToken.anyLive(refreshToken = Option(refreshToken))

    assert(token.canRefreshWith(UUID.fromString("aaaa-bbbb-cccc-dddd-eeee"), "wrong_gran_type") === false)
  }

  test("Can refresh it") {
    val refreshToken = UUID.fromString("aaaa-bbbb-cccc-dddd-eeee")
    val token = BuilderToken.anyExpired(refreshToken = Option(refreshToken))

    assert(token.isExpired === true)
    val newToken = token.refresh(refreshToken, "refresh_token")

    assert(newToken match {
      case Some(ntoken) => ntoken.isExpired
    } === true)
  }
}
