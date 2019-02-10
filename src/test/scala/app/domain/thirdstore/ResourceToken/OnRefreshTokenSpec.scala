package test.app.domain.thirdstore.Resource

import app.domain.Token
import builders.{BuildResourceToken, BuildToken, BuildUuid}
import org.scalatest.FunSuite
import org.scalatest.Matchers._

class OnRefreshTokenSpec extends FunSuite{

  test("Can have a token") {
    val resWithLiveToken = BuildResourceToken.withLiveToken()

    assert(resWithLiveToken.token.isInstanceOf[Token])
  }


  test("Token for resource might be or not expired") {
    var resourceWithExpiredToken = BuildResourceToken.withExpiredToken()
    val resourceWithLiveToken = BuildResourceToken.withLiveToken()

    assert(resourceWithExpiredToken.isTokenExpired() === true)
    assert(resourceWithLiveToken.isTokenExpired() === false)
  }

  test("Can refresh an expired token") {
    val givenRefreshUuid = BuildUuid.uuidOne()
    val givenTokenExpired = BuildToken.anyExpired(withRefreshToken = givenRefreshUuid)
    val givenResourceExpired = BuildResourceToken.withToken(withToken = givenTokenExpired)

    assert(givenResourceExpired.isTokenExpired() === true)
    givenResourceExpired.refreshToken(givenRefreshUuid, "refresh_token")
    assert(givenResourceExpired.isTokenExpired() === false)
  }

  test("Cannot refresh a live token") {
    val refreshToken = BuildUuid.uuidOne()
    val resourceExpired = BuildResourceToken.withToken(
      withToken = BuildToken.anyLive(withRefreshToken = refreshToken)
    )

    the [IllegalAccessException] thrownBy(
      resourceExpired.refreshToken(refreshToken, "refresh_token")
    ) should have message "The token must be expired in order to be refreshed"
  }

  test("Receives an exception on Refreshing token with wrong refresh_token uuid") {
    val givenWrongRefreshUui = BuildUuid.uuidTwo()
    val givenResourceExpired = BuildResourceToken.withToken(
      withToken = BuildToken.anyExpired(
        withRefreshToken = BuildUuid.uuidOne()
      )
    )

    the [IllegalAccessException] thrownBy(
      givenResourceExpired.refreshToken(givenWrongRefreshUui, "refresh_token")
    ) should have message "The parameters used to refresh the token are invalid."

  }
}
