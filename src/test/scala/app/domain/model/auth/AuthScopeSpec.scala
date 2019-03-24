package test.app.domain.model.auth

import app.domain.model.auth.AuthScope
import org.scalatest.FunSuite

class AuthScopeSpec extends FunSuite {

  test("An scope that forbid everything cannot be created") {
    val thrown = intercept[IllegalArgumentException] {
      AuthScope(false, false, false)
    }
    assert(thrown.getMessage() === "An scope that forbid everything doesnt make sense")
  }
}
