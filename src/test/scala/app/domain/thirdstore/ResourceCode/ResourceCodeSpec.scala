package test.app.domain.thirdstore.ResourceCode

import builders.BuildResourceCode
import org.scalatest.FunSuite

class ResourceCodeSpec extends FunSuite {

    test("The resource code might have an expired code") {
        val resourceExpired = BuildResourceCode.withExpiredCode()

        assert(resourceExpired.isCodeExpired() === true)

    }
}
