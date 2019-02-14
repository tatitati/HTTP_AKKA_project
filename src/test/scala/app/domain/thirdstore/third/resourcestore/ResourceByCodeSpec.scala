package app.domain.thirdstore.third.resourcestore

import app.domain.thirdstore.resourcestore.ResourceByToken
import org.scalatest.FunSuite
import test.builders.BuildResourceByCode

class ResourceByCodeSpec extends FunSuite {

  test("I can create a ResourceToken from a ResourceCode") {
    val resourceCode = BuildResourceByCode.any()

    val resourceToken = resourceCode.toResourceByToken()

    assert(resourceToken.isInstanceOf[ResourceByToken])
    assert(resourceToken.isTokenExpired() === false)
  }
}
