package app.domain.factories

import app.domain.resource.Token
import org.scalatest.FunSuite

class FactoryTokenSpec extends FunSuite {

  test("Can create new Tokens") {
    val token = FactoryToken.create()

    assert(token.isInstanceOf[Token])
  }
}
