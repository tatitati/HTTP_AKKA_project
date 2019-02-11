package test.app.domain.thirdstore.ResourceCode

import app.domain.thirdstore.ResourceToken
import builders.{BuildResourceCode, BuildThirdProfile}
import org.scalatest.FunSuite

class ResourceCodeSpec extends FunSuite {

    test("The resource code might have an expired code") {
        val resourceCodeExpired = BuildResourceCode.anyExpired()
        assert(resourceCodeExpired.isCodeExpired() === true)
    }

    test("It checks the code and if is live") {
      val resourceCodeLive = BuildResourceCode.anyLive(
        withCode = "code1"
      )

      assert(resourceCodeLive.canExportToRecourceToken(withCode = "code2") === false)
      assert(resourceCodeLive.canExportToRecourceToken(withCode = "code1") === true)


    }

    test("if ResourceCode is expired, then it cannot be transformed into a ResourceToken") {
      val resourceCodeExpired = BuildResourceCode.anyExpired(
        withCode = "codeA"
      )

      assert(resourceCodeExpired.canExportToRecourceToken(withCode = "codeA") === false)
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
}
