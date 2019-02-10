package test.app.domain.thirdstore.ResourceCode

import builders.{BuildResourceCode, BuildThirdProfile}
import org.scalatest.FunSuite

class ResourceCodeSpec extends FunSuite {

    test("The resource code might have an expired code") {
        val resourceCodeExpired = BuildResourceCode.anyExpired()

        assert(resourceCodeExpired.isCodeExpired() === true)
    }

    test("can export a ResourceToken if code is not expired") {
      val resourceCodeLive = BuildResourceCode.anyLive(
        withCode = "code1"
      )

      assert(
        resourceCodeLive.canExportToRecourceToken(withCode = "code2") === false
      )

      assert(
        resourceCodeLive.canExportToRecourceToken(withCode = "code1") === true
      )
    }
}
