package test.app.domain.thirdstore.Resource

import app.domain.Token
import builders.{BuildResource, BuildToken, BuildUuid}
import org.scalatest.FunSuite

class CanManageTokenSpec extends FunSuite{

  test("Might or not have a token") {
    val resourceWithLiveToken = BuildResource.withLiveToken()
    val resourceWithoutToken = BuildResource.withoutToken()
    val resourceWithRevokedToken = BuildResource.withRevokedToken()

    assert(resourceWithLiveToken.token.isInstanceOf[Some[Token]])
    assert(resourceWithoutToken.token === None)
    assert(resourceWithRevokedToken.isExpired() === None)
  }


  test("Token to access resource might be or not expired") {
    var resourceWithExpiredToken = BuildResource.withExpiredToken()
    val resourceWithLiveToken = BuildResource.withLiveToken()

    assert(resourceWithExpiredToken.isExpired() === Some(true))
    assert(resourceWithLiveToken.isExpired() === Some(false))
  }


  test("Can revoke resource token") {
    val resourceWithLiveToken = BuildResource.withLiveToken()

    resourceWithLiveToken.revoke()

    assert(resourceWithLiveToken.token === None)
  }


  test("Can refresh an expired token") {
    val refreshToken = BuildUuid.uuidOne()
    val resourceExpired = BuildResource.withToken(
      withToken = BuildToken.anyExpired(withRefreshToken = refreshToken)
    )

    val originalToken = resourceExpired.token

    resourceExpired.refreshToken(refreshToken, "refresh_token")

    assert(resourceExpired.isExpired() === Some(false))
    assert(resourceExpired.token !== originalToken)
  }

  test("Cannot refresh a live token") {
    val refreshToken = BuildUuid.uuidOne()
    val resourceExpired = BuildResource.withToken(
      withToken = BuildToken.anyLive(withRefreshToken = refreshToken)
    )

    val originalToken = resourceExpired.token

    resourceExpired.refreshToken(refreshToken, "refresh_token")

    assert(resourceExpired.token === originalToken)
  }


  test("Cannot refresh if resource has not a token at all") {
    val randomRefreshToken = BuildUuid.uuidOne()
    val resourceWithoutToken = BuildResource.withoutToken()

    resourceWithoutToken.refreshToken(randomRefreshToken, "refresh_token")

    assert(resourceWithoutToken.token === None)
  }
}
