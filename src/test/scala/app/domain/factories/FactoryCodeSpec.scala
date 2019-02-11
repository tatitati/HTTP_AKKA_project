package app.domain.factories

import app.domain.thirdstore.resourcestore.Code
import org.scalatest.FunSuite

class FactoryCodeSpec extends FunSuite {
  test("Can create a Code") {
    val code = FactoryCode.create(state = "anystate")

    assert(code.isInstanceOf[Code])
  }
}
