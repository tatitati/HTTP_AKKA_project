package app.domain.thirdstore

import builders.BuildThird
import org.scalatest.FunSuite

class ThirdSpec extends FunSuite {

  test("Can export state (memento)") {
    val third = BuildThird.any()

    val memento = third.exportMemento()

    assert(memento.isInstanceOf[MementoThird] === true)
  }

  test("can refresh third credentials if they are compromised") {
    val third = BuildThird.any()

    val clientId = third.exportMemento().clientId

    third.refreshCredentials()
  }

  test("can edit third basic profile") {
    val third = BuildThird.any(name = "first name")

    assert(third.profile.name === "first name")
    third.profile.name = "second name"
    assert(third.profile.name === "second name")
  }

  test("can edit clientid or clientsecret") {
    val third = BuildThird.any(clientId = "clientid1")

    assert(third.profile.clientid === "clientid1")
    third.profile.name = "clientid2"
    assert(third.profile.name === "clientid2")
  }
}
