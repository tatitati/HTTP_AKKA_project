package app.domain.thirdstore

import builders.{BuildThird, BuildThirdProfile}
import org.scalatest.FunSuite

class ThirdSpec extends FunSuite {

  test("A third is built with a third profile and one resource") {
    val third = BuildThird.any()
    assert(third.isInstanceOf[Third])
  }

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
    val givenThird = BuildThird.any(
      withThirdProfile = BuildThirdProfile.any(
        withName = "first name"
      )
    )

    assert(givenThird.profile.name === "first name")
    givenThird.profile.name = "second name"
    assert(givenThird.profile.name === "second name")
  }

  test("can edit clientid or clientsecret") {
    val givenThird = BuildThird.any(
      withThirdProfile = BuildThirdProfile.any(
        withClientid = "clientid1"
      )
    )

    assert(givenThird.profile.clientid === "clientid1")
    givenThird.profile.name = "clientid2"
    assert(givenThird.profile.name === "clientid2")
  }
}
