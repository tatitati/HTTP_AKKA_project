package test.app.domain.model

import app.domain.model.Scope
import org.scalatest.FunSuite

class AuthScopeSpec extends FunSuite {

  test("An scope that forbid everything cannot be created") {
    val thrown = intercept[IllegalArgumentException] {
      Scope(false, false, false)
    }
    assert(thrown.getMessage() === "An scope that forbid everything doesnt make sense")
  }
}
