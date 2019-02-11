package test.app.domain.thirdstore.ResourceCode

import app.domain.thirdstore.ResourceToken
import builders.BuildResourceCode
import org.scalatest.FunSuite

class ResourceCodeSpec extends FunSuite {

    test("The resource code might have an expired code") {
        val resourceCodeExpired = BuildResourceCode.anyExpired()
        assert(resourceCodeExpired.isCodeExpired() === true)
    }

    test("Exception is triggered when the code is expired") {
      val resourceCodeLive = BuildResourceCode.anyExpired(
        withCode = "code1"
      )

      val thrown = intercept[IllegalArgumentException] {
        resourceCodeLive.toResourceToken()
      }
      assert(thrown.getMessage === "An expired code cannot be used to get a token")
    }

    test("Can convert a ResourceCode into a ResourceToken") {
      val resourceCodeLive = BuildResourceCode.anyLive(
        withCode = "code1"
      )

      assert(resourceCodeLive.toResourceToken().isInstanceOf[ResourceToken])
    }
}
