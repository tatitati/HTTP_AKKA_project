package app.domain.thirdstore

import builders.{BuildResource, BuildThird}
import org.scalatest.FunSuite

class ThirdSpec extends FunSuite {
  
  test("Can revoke a resource") {
    val resource = BuildResource.anyWithLiveToken()

    val third = BuildThird.any()
  }
}
