package app.domain.thirdstore

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



  test("Might or not have a token") {
    val resource1 = BuilderResource.anyWithLiveToken()
    assert(resource1.gettoken().isInstanceOf[Some[Token]])

    val resource2 = BuilderResource.anyWithoutToken()
    assert(resource2.gettoken() === None)

    val resource3 = BuilderResource.anyRevoked()
    assert(resource3.isTokenExpired() === None)
  }



  test("Might or not have an expired token") {
    var resource = BuilderResource.anyWithExpiredToken()
    assert(resource.isTokenExpired() === Some(true))

    resource = BuilderResource.anyWithLiveToken()
    assert(resource.isTokenExpired() === Some(false))
  }



  test("Can revoke token") {
    val resource = BuilderResource.anyWithLiveToken()

    assert(resource.gettoken().isInstanceOf[Some[Token]])
    resource.revokeToken()
    assert(resource.gettoken() === None)
  }



  test("Can refresh an expired token") {
    val resource = BuilderResource.anyWithExpiredToken()

    assert(resource.isTokenExpired() === Some(true))
    resource.refreshToken()
    assert(resource.isTokenExpired() === Some(false))
  }

  test("Cannot refresh if resource has not a token already") {
    val resource = BuilderResource.anyWithoutToken()

    resource.refreshToken()
    assert(resource.gettoken() === None)
  }
}
