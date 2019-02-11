package test.app.domain.thirdstore

import app.domain.thirdstore.{ResourceToken, ResourceTokenFactory}
import builders.BuildResourceCode
import org.scalatest.FunSuite

class ResourceTokenSpec extends FunSuite {

  test("I can create a ResourceToken from a ResourceCode") {
    val resourceCode = BuildResourceCode.any()

    val resourceToken = ResourceTokenFactory.fromResourceCode(resourceCode)

    assert(resourceToken.isInstanceOf[ResourceToken])
    assert(resourceToken.isTokenExpired() === false)
  }
}
