package app.domain.thirdstore

import builders.BuildThird
import org.scalatest.FunSuite

class ThirdSpec extends FunSuite {

  test("can refresh third credentials if they are compromised") {
    val third = BuildThird.any()

    val clientId = third.profile.clientid
    val clientSecret = third.profile.clientsecret

    third.refreshCredentials()

    val newclientid = third.profile.clientid
    val newclientSecret = third.profile.clientsecret

    assert(clientId !== newclientid)
    assert(clientSecret !== newclientSecret)
  }

  test("can edit third basic profile") {
    val third = BuildThird.any(withName = "first name")

    assert(third.profile.name === "first name")
    third.profile.name = "second name"
    assert(third.profile.name === "second name")
  }

  test("can edit clientid or clientsecret") {
    val third = BuildThird.any(withClientId = "clientid1")

    assert(third.profile.clientid === "clientid1")
    third.profile.name = "clientid2"
    assert(third.profile.name === "clientid2")
  }
}
