package app.domain.thirdstore

import builders.BuildResource
import builders.authorizes.BuildScope
import org.scalatest.FunSuite

class ResourceSpec extends FunSuite{

  test("Has an Scope") {
    val resource = BuildResource.anyWithLiveToken(
      withsurname = "my surname",
      scope = Option(BuildScope.onlySurname())
    )

    assert(resource.email() === None)
    assert(resource.firstname() === None)
    assert(resource.surname() === Some("my surname"))
  }



  test("Might or not have a token") {
    val resource1 = BuildResource.anyWithLiveToken()
    assert(resource1.gettoken().isInstanceOf[Some[Token]])

    val resource2 = BuildResource.anyWithoutToken()
    assert(resource2.gettoken() === None)

    val resource3 = BuildResource.anyRevoked()
    assert(resource3.isTokenExpired() === None)
  }



  test("Might or not have an expired token") {
    var resource = BuildResource.anyWithExpiredToken()
    assert(resource.isTokenExpired() === Some(true))

    resource = BuildResource.anyWithLiveToken()
    assert(resource.isTokenExpired() === Some(false))
  }



  test("Can revoke token") {
    val resource = BuildResource.anyWithLiveToken()

    assert(resource.gettoken().isInstanceOf[Some[Token]])
    resource.revokeToken()
    assert(resource.gettoken() === None)
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
    assert(resource.gettoken() === None)
  }
}
