package test.app.domain.thirdstore.Resource

import app.domain.Token
import builders.BuildResource
import org.scalatest.FunSuite

class CanManageTokenSpec extends FunSuite{

  test("Might or not have a token") {
    val givenResource1 = BuildResource.anyWithLiveToken()
    assert(givenResource1.token.isInstanceOf[Some[Token]])

    val givenResource2 = BuildResource.anyWithoutToken()
    assert(givenResource2.token === None)

    val givenResource3 = BuildResource.anyRevoked()
    assert(givenResource3.isTokenExpired() === None)
  }



  test("Token to access resource might be or not expired") {
    var givenResource = BuildResource.anyWithExpiredToken()
    assert(givenResource.isTokenExpired() === Some(true))

    givenResource = BuildResource.anyWithLiveToken()
    assert(givenResource.isTokenExpired() === Some(false))
  }



  test("Can revoke resource token") {
    val givenResource = BuildResource.anyWithLiveToken()

    assert(givenResource.token.isInstanceOf[Some[Token]])
    givenResource.revokeToken()
    assert(givenResource.token === None)
  }



  test("Can refresh an expired token") {
    val givenResource = BuildResource.anyWithExpiredToken()

    assert(givenResource.isTokenExpired() === Some(true))
    givenResource.refreshToken()
    assert(givenResource.isTokenExpired() === Some(false))
  }

  test("Cannot refresh if resource has not a token already") {
    val givenResource = BuildResource.anyWithoutToken()

    givenResource.refreshToken()
    assert(givenResource.token === None)
  }
}
