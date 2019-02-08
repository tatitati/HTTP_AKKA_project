package test.app.domain.thirdstore.Resource

import builders.BuildResource
import builders.authorizes.BuildScope
import org.scalatest.FunSuite

import scala.util.{Failure, Success}

class CanReadProfileSpec extends FunSuite{

  test("Can read data when allowed and token is live") {
    val givenResource1 = BuildResource.withLiveToken(
      withsurname = "my surname",
      scope = Option(BuildScope.onlySurname())
    )

    assert(givenResource1.surname() === Some("my surname"))
  }

  test("Cannot read data when not allowed even though token is live") {
    val givenResource1 = BuildResource.withLiveToken(
      scope = Option(BuildScope.onlySurname())
    )

    assert(givenResource1.email() === None)
  }

  test("Even if the scope allows it, if the token is expired then the profile cannot be read") {
    val givenResource2 = BuildResource.withExpiredToken(
      withsurname = "my surname",
      scope = Option(BuildScope.onlySurname())
    )
    
    assert(givenResource2.surname() === None, "=> Should returns None because even when the scope allows it, the token is expired")
  }
}
