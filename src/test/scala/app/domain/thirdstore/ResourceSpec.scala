package app.domain.thirdstore

import app.domain.Token
import builders.BuildResource
import builders.authorizes.BuildScope
import org.scalatest.FunSuite

class ResourceSpec extends FunSuite{

  test("Resource check token expiration before accessing owner profile AND the scope") {
    val givenResource1 = BuildResource.anyWithLiveToken(
      withsurname = "my surname",
      scope = Option(BuildScope.onlySurname())
    )

    assert(givenResource1.email() === None)
    assert(givenResource1.firstname() === None)
    assert(givenResource1.surname() === Some("my surname"), "=> Should return the surname because the scope allows it and the token is live")


    val givenResource2 = BuildResource.anyWithExpiredToken(
      withsurname = "my surname",
      scope = Option(BuildScope.onlySurname())
    )

    assert(givenResource2.email() === None)
    assert(givenResource2.firstname() === None)
    assert(givenResource2.surname() === None, "=> Should returns None because even when the scope allows it, the token is expired")
  }



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
