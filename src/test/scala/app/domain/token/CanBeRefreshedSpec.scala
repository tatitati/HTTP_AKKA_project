package app.domain.token

import builders.{BuildToken, BuildUuid}
import org.scalatest.FunSuite

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

//  test("Can refresh an expired token") {
//    val givenRefreshToken = BuildUuid.uuidOne()
//    val givenExpiredToken = BuildToken.anyExpired(
//      withRefreshToken = givenRefreshToken
//    )
//
//    val thenNewToken = givenExpiredToken.refresh(
//      refreshToken = givenRefreshToken,
//      grantType = "refresh_token"
//    )
//
//    assert(
//      thenNewToken match {
//        case Some(newtoken) => newtoken.equals(givenExpiredToken) === false
//        case _ => false
//    })
//  }
//
//  test("Cannot refresh a live token") {
//    val givenRefreshToken = BuildUuid.uuidOne()
//    val givenExpiredToken = BuildToken.anyLive(
//      withRefreshToken = givenRefreshToken
//    )
//
//    val thenNewToken = givenExpiredToken.refresh(
//      refreshToken = givenRefreshToken,
//      grantType = "refresh_token"
//    )
//
//    assert(!thenNewToken.equals(givenExpiredToken))
//    assert(thenNewToken === None)
//  }
}
