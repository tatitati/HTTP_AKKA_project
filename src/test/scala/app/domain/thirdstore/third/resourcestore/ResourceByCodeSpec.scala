package app.domain.thirdstore.third.resourcestore

import app.domain.thirdstore.resourcestore.ResourceByToken
import builders.BuildResourceByCode
import org.scalatest.FunSuite

class ResourceByCodeSpec extends FunSuite {

  test("I can create a ResourceToken from a ResourceCode") {
    val resourceCode = BuildResourceByCode.any()

    val resourceToken = resourceCode.toResourceByToken()

    assert(resourceToken.isInstanceOf[ResourceByToken])
    assert(resourceToken.isTokenExpired() === false)
  }
}
