package test.app.domain.resource

import app.domain.resource._
import builders.domain.BuildResourceByCode
import com.github.nscala_time.time.Imports.DateTime
import org.scalatest.FunSuite

class ResourceByCodeSpec extends FunSuite {

  test("Can convert a ResourceByCode into a ResourceByToken") {
    val resourceCode = BuildResourceByCode.any()

    val resourceToken = resourceCode.exchangeByResourceByToken()

    assert(resourceToken.isInstanceOf[ResourceByToken])
    assert(resourceToken.isTokenExpired() === false)
  }

  test("Can export memento to allow serialization of its whole state and keep encapsulation") {
    val resourceCode = BuildResourceByCode.specific()

    val memento = resourceCode.memento()

    assert(memento.code === "code")
    assert(memento.ownerEmail === "email")
    assert(memento.codeGeneratedIn === new DateTime("2015-02-10"))
  }
}
