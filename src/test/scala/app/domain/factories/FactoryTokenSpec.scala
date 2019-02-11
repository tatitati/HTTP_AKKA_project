package app.domain.factories

import app.domain.Token
import org.scalatest.FunSuite

class FactoryTokenSpec extends FunSuite {

  test("Can create new Tokens") {
    val token = FactoryToken.createBearer()

    assert(token.isInstanceOf[Token])
  }
}
