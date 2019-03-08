package test.app.domain.thirdstore.third

import org.scalatest.FunSuite
import test.builders.BuildThird

class OnManageThirdCredentialsSpec extends FunSuite {

  test("can refresh third credentials if they are compromised") {
    val givenThird = BuildThird.any()
    val credentialsOriginal = givenThird.getCredentials

    givenThird.refreshCredentials()
    val credentialsUpdated = givenThird.getCredentials

    assert(credentialsOriginal !== credentialsUpdated)
  }
}
