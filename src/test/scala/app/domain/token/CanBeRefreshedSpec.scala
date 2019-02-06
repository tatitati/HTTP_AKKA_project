package app.domain.token

import builders.{BuildToken, BuildUuid}
import org.scalatest.FunSuite

class CanBeRefreshedSpec extends FunSuite{
  test("WHEN using proper grant-type THEN can be refreshed") {
    val rightRefreshToken = BuildUuid.uuidOne()
    val wrongRefreshToken = BuildUuid.uuidTwo()
    val givenTOken = BuildToken.anyLive(
      withRefreshToken = rightRefreshToken
    )

    assert(givenTOken.canRefreshWith(rightRefreshToken, "refresh_token") === true)
    assert(givenTOken.canRefreshWith(wrongRefreshToken, "refresh_token") === false)
  }

  test("WHEN using wrong grant-type THEN cannot be refreshed") {
    val rightRefreshToken = BuildUuid.uuidOne()
    val givenToken = BuildToken.anyLive(
      withRefreshToken = rightRefreshToken
    )

    assert(givenToken.canRefreshWith(rightRefreshToken, "wrong_gran_type") === false)
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
