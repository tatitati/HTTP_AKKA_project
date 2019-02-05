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
}
