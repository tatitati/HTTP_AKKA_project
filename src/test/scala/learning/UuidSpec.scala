package test.learning

import java.util.UUID
import org.scalatest._
import org.scalatest.FunSuite

class UuidSpec extends FunSuite with Matchers {

  test("Can generate random UUIDs") {
    val uuid = java.util.UUID.randomUUID

    assert(uuid.isInstanceOf[UUID])
  }

  test("UUIds always follow a certain pattern") {
    val uuid = java.util.UUID.randomUUID

    assert(uuid.toString.matches(".*-.*-.*-.*-.*") === true)
  }
}
