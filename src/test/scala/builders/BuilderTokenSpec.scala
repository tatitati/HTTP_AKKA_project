package builders

import java.util.UUID
import app.domain.thirdstore.Token
import org.scalatest.FunSuite
import test.builders.BuilderToken

class BuilderTokenSpec extends FunSuite{

  test("Builder can create a token") {
    val token = BuilderToken.anyLive()
    assert(token.isInstanceOf[Token])
  }

  test("Builder can create a token with an specific refresh token") {
    val refreshToken = UUID.fromString("aaaa-bbbb-cccc-dddd-eeee")
    val token = BuilderToken.anyLive(refreshToken = Option(refreshToken))

    assert(token.isInstanceOf[Token])
  }
}
