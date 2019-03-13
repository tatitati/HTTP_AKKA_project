package app.domain

import org.scalatest.FunSuite

class IdentifiableInPersistenceSpec extends FunSuite {

    class Concrete extends IdentifiableInPersistence {
      def getSurroId(): Option[Long] = {
        getSurrogateId()
      }
    }

    test("By default the surrogate-id is None") {
      val a = new Concrete()

      assert(a.getSurroId().isInstanceOf[Option[Long]])
      assert(a.getSurroId() == None)
    }

  test("I can set a surrogate-id") {
    val a = new Concrete()

    a.setSurrogateId(withSurrogateId = 23)
    assert(a.getSurroId() === Some(23))
  }

  test("A surrogate is immutable once that is set") {
    val a = new Concrete()

    a.setSurrogateId(withSurrogateId = 23)


    val thrown = intercept[IllegalArgumentException] {
      a.setSurrogateId(withSurrogateId = 24)
    }
    assert(thrown.getMessage() === "Surrogate ID cannot be modified once that is set")
  }
}