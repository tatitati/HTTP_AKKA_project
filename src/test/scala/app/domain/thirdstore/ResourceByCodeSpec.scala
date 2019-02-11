package test.app.domain.thirdstore


import app.domain.thirdstore.{ResourceByToken => ResByToken}
import builders.BuildResourceByCode
import org.scalatest.FunSuite

class ResourceByCodeSpec extends FunSuite {

  test("I can create a ResourceToken from a ResourceCode") {
    val resourceCode = BuildResourceByCode.any()

    val resourceToken = resourceCode.toResourceByToken()

    assert(resourceToken.isInstanceOf[ResByToken])
    assert(resourceToken.isTokenExpired() === false)
  }
}
