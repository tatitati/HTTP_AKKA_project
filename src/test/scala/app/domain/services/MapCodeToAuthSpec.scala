package app.domain.services

import app.domain.model.auth.Auth
import org.scalatest.FunSuite
import test.app.domain.code.BuildCode

class MapCodeToAuthSpec extends FunSuite {

  test("A code is converted into an auth") {
    val givenCode = BuildCode.any()

    val auth = MapCodeToAuth.toAuth(givenCode)

    assert(auth.isInstanceOf[Auth])
  }
}
