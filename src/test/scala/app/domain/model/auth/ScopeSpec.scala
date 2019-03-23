package test.app.domain.model.auth

import app.domain.model.auth.Scope
import org.scalatest.FunSuite

class ScopeSpec extends FunSuite {

  test("An scope that forbid everything cannot be created") {
    val thrown = intercept[IllegalArgumentException] {
      Scope(false, false, false)
    }
    assert(thrown.getMessage() === "An scope that forbid everything doesnt make sense")
  }
}
