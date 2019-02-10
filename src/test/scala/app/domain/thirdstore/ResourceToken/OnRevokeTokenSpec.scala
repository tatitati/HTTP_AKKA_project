package test.app.domain.thirdstore.Resource

import builders.BuildResourceToken
import org.scalatest.FunSuite

class OnRevokeTokenSpec extends FunSuite{

  test("Can revoke resource token") {
    val resourceWithLiveToken = BuildResourceToken.withLiveToken()

    resourceWithLiveToken.revoke()

    assert(resourceWithLiveToken.token === None)
  }

  test("Receives an exception if there is no token") {
    val resourceWithLiveToken = BuildResourceToken.withoutToken()

    val thrown = intercept[IllegalAccessException] {
      resourceWithLiveToken.revoke()
    }
    assert(thrown.getMessage === "There is no token, so it cannot be revoked.")

  }
}
