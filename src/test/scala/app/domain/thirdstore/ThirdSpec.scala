package app.domain.thirdstore

import builders.{BuilderResource, BuilderThird}
import org.scalatest.FunSuite

class ThirdSpec extends FunSuite {
  
  test("Can revoke a resource") {
    val resource = BuilderResource.anyWithLiveToken()

    val third = BuilderThird.any()
  }
}
