package test.app.domain.thirdstore.third

import builders.domain.{BuildThird, BuildThirdProfile}
import org.scalatest.FunSuite

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
