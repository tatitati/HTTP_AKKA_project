package app.domain.thirdstore.third

import builders.{BuildThird, BuildThirdProfile}
import org.scalatest.FunSuite

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
