package test.app.domain.thirdstore.third

import org.scalatest.FunSuite
import test.builders.{BuildThird, BuildThirdProfile}

class OnEditThirdProfileSpec extends FunSuite {

  test("can edit third basic profile") {
    val givenThird = BuildThird.any(
      withThirdProfile = BuildThirdProfile.any(
        withName = "first name"
      )
    )

    givenThird.updateName("second name")

    assert(givenThird.getProfile.name === "second name")
  }
}
