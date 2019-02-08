package buildersSpec

import java.util.UUID

import app.domain.Token
import builders.BuildToken
import org.scalatest.FunSuite

class BuildTokenSpec extends FunSuite{

  test("Builder can create a token") {
    val token = BuildToken.anyLive()
    assert(token.isInstanceOf[Token])
  }

  test("Builder can create a token with an specific refresh token") {
    val refreshToken = UUID.fromString("aaaa-bbbb-cccc-dddd-eeee")
    val token = BuildToken.anyLive(withRefreshToken = refreshToken)

    assert(token.isInstanceOf[Token])
  }
}
