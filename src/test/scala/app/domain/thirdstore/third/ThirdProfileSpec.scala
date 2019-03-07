package app.domain.thirdstore.third

import app.domain.thirdstore.ThirdProfile
import org.scalatest.FunSuite
import test.builders.BuildThirdProfile

class ThirdProfileSpec extends FunSuite {

    test("can modify name in a FP way") {
      val profile = BuildThirdProfile.any(withName = "one third name")

      val updated = profile.setName("new third name")

      assert(updated.isInstanceOf[ThirdProfile])
      assert(updated.name === "new third name", "only name is updated")
      assert(profile.description === updated.description, "description is not modified")
    }
}
