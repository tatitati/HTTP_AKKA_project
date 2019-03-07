package test.app.domain.thirdstore.third

import org.scalatest.FunSuite
import test.builders.BuildThird

class OnManageThirdCredentialsSpec extends FunSuite {

  test("can refresh third credentials if they are compromised") {
    val givenThird = BuildThird.any()
    val clientId = givenThird.credentials.clientId
    val clientSecret = givenThird.credentials.clientSecret

    val updatedThird = givenThird.refreshCredentials()

    val newclientid = updatedThird.profile.clientid
    val newclientSecret = updatedThird.profile.clientsecret

    assert(clientId !== newclientid)
    assert(clientSecret !== newclientSecret)
  }
}
