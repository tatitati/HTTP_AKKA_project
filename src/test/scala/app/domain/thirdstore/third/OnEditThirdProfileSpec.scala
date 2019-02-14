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

    assert(givenThird.profile.name === "first name")
    givenThird.profile.name = "second name"
    assert(givenThird.profile.name === "second name")
  }
}
