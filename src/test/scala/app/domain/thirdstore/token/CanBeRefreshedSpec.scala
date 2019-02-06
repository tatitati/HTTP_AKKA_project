package app.domain.thirdstore.token

import java.util.UUID
import builders.{BuildToken, BuildUuid}
import org.scalatest.FunSuite

class CanBeRefreshedSpec extends FunSuite{
  test("Can know if can be refreshed when used the proper refresh token") {
    val givenRefreshToken = UUID.fromString("aaaa-bbbb-cccc-dddd-eeee")
    val givenTOken = BuildToken.anyLive(
      withRefreshToken = givenRefreshToken
    )

    assert(givenTOken.canRefreshWith(UUID.fromString("aaaa-bbbb-cccc-dddd-eeee"), "refresh_token") === true)
    assert(givenTOken.canRefreshWith(UUID.fromString("aaaa-eeea-aaaa-eeee-aaaa"), "refresh_token") === false)
  }

  test("Can know if can be refreshed when used the proper grant_type ") {
    val givenRefreshToken = UUID.fromString("aaaa-bbbb-cccc-dddd-eeee")
    val givenTOken = BuildToken.anyLive(
      withRefreshToken = givenRefreshToken
    )

    assert(givenTOken.canRefreshWith(UUID.fromString("aaaa-bbbb-cccc-dddd-eeee"), "wrong_gran_type") === false)
  }

  test("Can refresh an expired token") {
    val givenRefreshTOken = BuildUuid.uuidOne()
    val givenExpiredToken = BuildToken.anyExpired(
      withRefreshToken = givenRefreshTOken
    )

    val thenNewToken = givenExpiredToken.refresh(
      refreshToken = givenRefreshTOken,
      grantType = "refresh_token"
    )

    assert(
      thenNewToken match {
        case Some(newtoken) => newtoken.equals(givenExpiredToken) === false
        case _ => false
    })
  }

  test("Cannot refresh a live token") {
    val givenRefreshToken = BuildUuid.uuidOne()
    val givenExpiredToken = BuildToken.anyLive(
      withRefreshToken = givenRefreshToken
    )

    val thenNewToken = givenExpiredToken.refresh(
      refreshToken = givenRefreshToken,
      grantType = "refresh_token"
    )

    assert(!thenNewToken.equals(givenExpiredToken))
    assert(thenNewToken === None)
  }
}
