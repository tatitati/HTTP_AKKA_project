package app.domain.thirdstore.token

import java.util.UUID
import builders.{BuildToken, BuildUuid}
import org.scalatest.FunSuite

class CanBeRefreshedSpec extends FunSuite{
  test("Can know if can be refreshed when used the proper refresh token") {
    val refreshToken = UUID.fromString("aaaa-bbbb-cccc-dddd-eeee")
    val token = BuildToken.anyLive(refreshToken = refreshToken)

    assert(token.canRefreshWith(UUID.fromString("aaaa-bbbb-cccc-dddd-eeee"), "refresh_token") === true)
    assert(token.canRefreshWith(UUID.fromString("aaaa-eeea-aaaa-eeee-aaaa"), "refresh_token") === false)
  }

  test("Can know if can be refreshed when used the proper grant_type ") {
    val refreshToken = UUID.fromString("aaaa-bbbb-cccc-dddd-eeee")
    val token = BuildToken.anyLive(refreshToken = refreshToken)

    assert(token.canRefreshWith(UUID.fromString("aaaa-bbbb-cccc-dddd-eeee"), "wrong_gran_type") === false)
  }

  test("Can refresh an expired token") {
    val refreshToken = BuildUuid.uuidOne()
    val expiredToken = BuildToken.anyExpired(refreshToken = refreshToken)

    val newToken = expiredToken.refresh(withRefreshToken = refreshToken, "refresh_token")

    assert(
      newToken match {
        case Some(newtoken) => newtoken.equals(expiredToken) === false
        case _ => false
    })
  }

  test("Cannot refresh a live token") {
    val refreshToken = BuildUuid.uuidOne()
    val expiredToken = BuildToken.anyLive(refreshToken = refreshToken)

    val newToken = expiredToken.refresh(withRefreshToken = refreshToken, "refresh_token")

    assert(!newToken.equals(expiredToken))
    assert(newToken === None)
  }
}
