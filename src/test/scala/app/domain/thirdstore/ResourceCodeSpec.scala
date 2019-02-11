package test.app.domain.thirdstore

import app.domain.thirdstore.ResourceToken
import builders.BuildResourceCode
import org.scalatest.FunSuite

class ResourceCodeSpec extends FunSuite {

  test("I can create a ResourceToken from a ResourceCode") {
    val resourceCode = BuildResourceCode.any()

    val resourceToken = resourceCode.toResourceToken()

    assert(resourceToken.isInstanceOf[ResourceToken])
    assert(resourceToken.isTokenExpired() === false)
  }
}
