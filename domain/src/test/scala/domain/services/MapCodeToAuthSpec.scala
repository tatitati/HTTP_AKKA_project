package domain.test.services

import domain.model.auth.Auth
import domain.services.MapCodeToAuth
import org.scalatest.FunSuite
import domain.test.model.code.BuildCode

class MapCodeToAuthSpec extends FunSuite {

  test("A code is converted into an auth") {
    val givenCode = BuildCode.any()

    val auth = MapCodeToAuth.toAuth(givenCode)

    assert(auth.isInstanceOf[Auth])
  }
}
