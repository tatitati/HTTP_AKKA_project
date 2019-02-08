package test.app.domain.thirdstore.Resource

import app.domain.Token
import builders.{BuildResource, BuildToken, BuildUuid}
import org.scalatest.FunSuite

class OnRefreshTokenSpec extends FunSuite{

  test("Can have a token") {
    val resWithLiveToken = BuildResource.withLiveToken()

    assert(resWithLiveToken.token.isInstanceOf[Some[Token]])
  }

  test("Might not have a token") {
    val resWithRevokedToken = BuildResource.withRevokedToken()
    val resWithoutToken = BuildResource.withoutToken()

    assert(resWithRevokedToken.token === None)
    assert(resWithoutToken.token === None)
  }


  test("Token for resource might be or not expired") {
    var resourceWithExpiredToken = BuildResource.withExpiredToken()
    val resourceWithLiveToken = BuildResource.withLiveToken()

    assert(resourceWithExpiredToken.isExpired() === true)
    assert(resourceWithLiveToken.isExpired() === false)
  }

  test("Can refresh an expired token") {
    val givenRefreshUuid = BuildUuid.uuidOne()
    val givenTokenExpired = BuildToken.anyExpired(withRefreshToken = givenRefreshUuid)
    val givenResourceExpired = BuildResource.withToken(withToken = givenTokenExpired)

    assert(givenResourceExpired.isExpired() === true)
    givenResourceExpired.refreshToken(givenRefreshUuid, "refresh_token")
    assert(givenResourceExpired.isExpired() === false)
  }

  test("Cannot refresh a live token") {
    val refreshToken = BuildUuid.uuidOne()
    val resourceExpired = BuildResource.withToken(
      withToken = BuildToken.anyLive(withRefreshToken = refreshToken)
    )

    assertThrows[IllegalAccessException] {
      resourceExpired.refreshToken(refreshToken, "refresh_token")
    }
  }

  test("On Refresh-token receives an exception if there is not token") {
    val givenRandomUuid = BuildUuid.uuidOne()
    val givenResourceWithoutToken = BuildResource.withoutToken()

    assertThrows[IllegalAccessException] {
      givenResourceWithoutToken.refreshToken(givenRandomUuid, "refresh_token")
    }
  }

  test("Receives an exception on Refreshing token with wrong refresh_token uuid") {
    val givenWrongRefreshUui = BuildUuid.uuidTwo()
    val givenResourceExpired = BuildResource.withToken(
      withToken = BuildToken.anyExpired(
        withRefreshToken = BuildUuid.uuidOne()
      )
    )

    assertThrows[IllegalAccessException] {
      givenResourceExpired.refreshToken(givenWrongRefreshUui, "refresh_token")
    }
  }
}
