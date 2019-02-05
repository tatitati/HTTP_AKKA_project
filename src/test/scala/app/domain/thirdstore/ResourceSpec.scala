package app.domain.thirdstore

import app.domain.Token
import builders.BuildResource
import builders.authorizes.BuildScope
import org.scalatest.FunSuite

class ResourceSpec extends FunSuite{

  test("Resource check token expiration before accessing owner profile AND the scope") {
    val resource1 = BuildResource.anyWithLiveToken(
      withsurname = "my surname",
      scope = Option(BuildScope.onlySurname())
    )

    assert(resource1.email() === None)
    assert(resource1.firstname() === None)
    assert(resource1.surname() === Some("my surname"), "=> Should return the surname because the scope allows it and the token is live")


    val resource2 = BuildResource.anyWithExpiredToken(
      withsurname = "my surname",
      scope = Option(BuildScope.onlySurname())
    )

    assert(resource2.email() === None)
    assert(resource2.firstname() === None)
    assert(resource2.surname() === None, "=> Should returns None because even when the scope allows it, the token is expired")
  }



  test("Might or not have a token") {
    val resource1 = BuildResource.anyWithLiveToken()
    assert(resource1.token.isInstanceOf[Some[Token]])

    val resource2 = BuildResource.anyWithoutToken()
    assert(resource2.token === None)

    val resource3 = BuildResource.anyRevoked()
    assert(resource3.isTokenExpired() === None)
  }



  test("Token to access resource might be or not expired") {
    var resource = BuildResource.anyWithExpiredToken()
    assert(resource.isTokenExpired() === Some(true))

    resource = BuildResource.anyWithLiveToken()
    assert(resource.isTokenExpired() === Some(false))
  }



  test("Can revoke resource token") {
    val resource = BuildResource.anyWithLiveToken()

    assert(resource.token.isInstanceOf[Some[Token]])
    resource.revokeToken()
    assert(resource.token === None)
  }



  test("Can refresh an expired token") {
    val resource = BuildResource.anyWithExpiredToken()

    assert(resource.isTokenExpired() === Some(true))
    resource.refreshToken()
    assert(resource.isTokenExpired() === Some(false))
  }

  test("Cannot refresh if resource has not a token already") {
    val resource = BuildResource.anyWithoutToken()

    resource.refreshToken()
    assert(resource.token === None)
  }
}
