package app.domain.thirdstore

import builders.BuildThird
import org.scalatest.FunSuite

class ThirdSpec extends FunSuite {

  test("Can export state (memento)") {
    val third = BuildThird.any()

    val memento = third.exportMemento()

    assert(memento.isInstanceOf[MementoThird] === true)
  }

  test("can refresh credentials if they are compromised") {
    val third = BuildThird.any()

    val clientId = third.exportMemento().clientId

    third.refreshCredentials()
  }

  test("can edit name") {
    val third = BuildThird.any(name = "first name")
    val memento1 = third.exportMemento()

    third.setname("second name")
    val memento2 = third.exportMemento()


    assert(memento1.name === "first name")
    assert(memento2.name === "second name")
  }
}
