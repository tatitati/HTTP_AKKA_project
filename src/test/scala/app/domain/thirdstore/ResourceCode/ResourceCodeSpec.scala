package test.app.domain.thirdstore.ResourceCode

import app.domain.thirdstore.ResourceToken
import builders.BuildResourceCode
import org.scalatest.FunSuite

class ResourceCodeSpec extends FunSuite {
    test("Can convert a ResourceCode into a ResourceToken") {
      val resourceCodeLive = BuildResourceCode.anyLive(
        withCode = "code1"
      )

      assert(resourceCodeLive.toResourceToken().isInstanceOf[ResourceToken])
    }
}
