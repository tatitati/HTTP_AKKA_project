package app.domain.thirdstore.third.resourcestore

import app.domain.thirdstore.resourcestore.ResourceByToken
import org.scalatest.FunSuite
import test.builders.BuildResourceByCode
import com.github.nscala_time.time.Imports.DateTime

class ResourceByCodeSpec extends FunSuite {

  test("Can convert a ResourceByCode into a ResourceByToken") {
    val resourceCode = BuildResourceByCode.any()

    val resourceToken = resourceCode.toResourceByToken()

    assert(resourceToken.isInstanceOf[ResourceByToken])
    assert(resourceToken.isTokenExpired() === false)
  }

  test("Can export memento to allow serialization of its whole state") {
    val resourceCode = BuildResourceByCode.specific()

    val memento = resourceCode.exportMemento()

    assert(memento.code === "code")
    assert(memento.ownerEmail === "email")
    assert(memento.codeGeneratedIn === new DateTime("2015-02-10"))
  }
}
