package app.domain.thirdstore.token

import app.domain.thirdstore.MementoToken
import builders.{BuildToken, BuildUuid}
import org.scalatest.FunSuite

class CanExportStateSpec extends FunSuite {

  test("When exporting memento it hides the implementation details") {
    val givenAccessToken = BuildUuid.uuidOne()
    val givenRefreshToken = BuildUuid.uuidTwo()
    val givenToken = BuildToken.anyLive(accessToken = givenAccessToken, refreshToken = givenRefreshToken)

    val memento = givenToken.exportMemento()

    assert(memento.isInstanceOf[MementoToken])
    // check that implementations details are hiden now, not needing to call any other method to get required values(strings)
    assert(memento.accessToken.isInstanceOf[String] && memento.accessToken === givenAccessToken.toString)
    assert(memento.refreshToken.isInstanceOf[String] && memento.refreshToken === givenRefreshToken.toString)
  }
}
