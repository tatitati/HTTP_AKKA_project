package test.app.domain.thirdstore.Resource

import builders.BuildResource
import org.scalatest.FunSuite
import org.scalatest.Matchers._

class OnRevokeTokenSpec extends FunSuite{

  test("Can revoke resource token") {
    val resourceWithLiveToken = BuildResource.withLiveToken()

    resourceWithLiveToken.revoke()

    assert(resourceWithLiveToken.token === None)
  }

  test("Receives an exception if there is no token") {
    val resourceWithLiveToken = BuildResource.withoutToken()

    the [IllegalAccessException] thrownBy(
      resourceWithLiveToken.revoke()
    ) should have message "There is no token, so it cannot be revoked."
  }
}
