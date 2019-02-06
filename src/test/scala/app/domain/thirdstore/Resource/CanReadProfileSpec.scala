package test.app.domain.thirdstore.Resource

import builders.BuildResource
import builders.authorizes.BuildScope
import org.scalatest.FunSuite

class CanReadProfileSpec extends FunSuite{

  test("When token is live, then we check scope") {
    val givenResource1 = BuildResource.withLiveToken(
      withsurname = "my surname",
      scope = Option(BuildScope.onlySurname())
    )

    assert(givenResource1.email() === None)
    assert(givenResource1.firstname() === None)
    assert(givenResource1.surname() === Some("my surname"), "=> Should return the surname because the scope allows it and the token is live")
  }

  test("Even if the scope allows it, if the token is expired then the profile cannot be read") {
    val givenResource2 = BuildResource.withExpiredToken(
      withsurname = "my surname",
      scope = Option(BuildScope.onlySurname())
    )

    assert(givenResource2.email() === None)
    assert(givenResource2.firstname() === None)
    assert(givenResource2.surname() === None, "=> Should returns None because even when the scope allows it, the token is expired")
  }
}
