package app.domain.token

import builders.{BuildToken, BuildUuid}
import org.scalatest.FunSuite

class CanBeRefreshedSpec extends FunSuite{
  test("Must be used the valid refresh_token") {
    val rightRefreshToken = BuildUuid.uuidOne()
    val wrongRefreshToken = BuildUuid.uuidTwo()
    val expiredToken = BuildToken.anyExpired(
      withRefreshToken = rightRefreshToken
    )

    assert(expiredToken.canRefresh(rightRefreshToken, "refresh_token") === true)
    assert(expiredToken.canRefresh(wrongRefreshToken, "refresh_token") === false)
  }

  test("Must be used the right grant-type") {
    val rightRefreshToken = BuildUuid.uuidOne()
    val expiredToken = BuildToken.anyExpired(
      withRefreshToken = rightRefreshToken
    )

    assert(expiredToken.canRefresh(rightRefreshToken, "wrong_gran_type") === false)
  }

  test("Must be expired the token") {
    val rightRefreshToken = BuildUuid.uuidOne()
    val liveToken = BuildToken.anyLive(
      withRefreshToken = rightRefreshToken
    )

    assert(liveToken.canRefresh(rightRefreshToken, "refresh_token") === false)
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
