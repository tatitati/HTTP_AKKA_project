package app.domain.thirdstore

import builders.{BuilderToken, BuilderUuid}
import org.scalatest.FunSuite

class TokenSpec extends FunSuite {

  test("When exporting memento it hides the implementation details") {
    val givenAccessToken = BuilderUuid.uuidOne()
    val givenRefreshToken = BuilderUuid.uuidTwo()
    val givenToken = BuilderToken.anyLive(accessToken = Option(givenAccessToken), refreshToken = Option(givenRefreshToken))

    val memento = givenToken.exportMemento()

    assert(memento.isInstanceOf[MementoToken])
    // check that implementations details are hiden now, not needing to call any other method to get required values(strings)
    assert(memento.accessToken.isInstanceOf[String] && memento.accessToken === givenAccessToken.toString)
    assert(memento.refreshToken.isInstanceOf[String] && memento.refreshToken === givenRefreshToken.toString)
  }
}
