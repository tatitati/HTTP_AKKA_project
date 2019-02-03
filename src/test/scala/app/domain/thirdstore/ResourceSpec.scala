package app.domain.thirdstore

import app.domain.thirdstore.Token
import builders.BuilderResource
import builders.authorizes.BuilderScope
import org.scalatest.FunSuite

class ResourceSpec extends FunSuite{

  test("Has an Scope") {
    val resource = BuilderResource.anyWithLiveToken(
      withsurname = "my surname",
      scope = Option(BuilderScope.onlySurname())
    )

    assert(resource.email() === None)
    assert(resource.firstname() === None)
    assert(resource.surname() === Some("my surname"))
  }

  test("Has a token") {
    val resource = BuilderResource.anyWithLiveToken()
    assert(resource.gettoken().isInstanceOf[Some[Token]])
  }

  test("Know if a token is expired") {
    var resource = BuilderResource.anyWithExpiredToken()
    assert(resource.isTokenExpired() === Some(true))

    resource = BuilderResource.anyWithLiveToken()
    assert(resource.isTokenExpired() === Some(false))
  }

  test("Know if a token is revoked") {
    var resource = BuilderResource.anyRevoked()
    assert(resource.isTokenExpired() === None)
  }

  test("Can revoke token") {
    val resource = BuilderResource.anyWithLiveToken()

    assert(resource.gettoken().isInstanceOf[Some[Token]])
    resource.revokeToken()
    assert(resource.gettoken() === None)
  }

  test("Can refresh token") {
    val resource = BuilderResource.anyWithExpiredToken()

    assert(resource.isTokenExpired() === Some(true))
    resource.refreshToken()
    assert(resource.isTokenExpired() === Some(false))
  }
}
