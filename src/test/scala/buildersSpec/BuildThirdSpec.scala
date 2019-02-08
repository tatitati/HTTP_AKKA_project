package buildersSpec

import app.domain.thirdstore.Third
import builders.{BuildThird, BuildThirdProfile}
import org.scalatest.FunSuite

class BuildThirdSpec extends FunSuite {
  test("Builder can create a user") {
    assert(BuildThird.any().isInstanceOf[Third])
  }

  test("Profile data is accessible in the third") {
    val givenThird = BuildThird.any(
      withThirdProfile = BuildThirdProfile.any(
        withName = "whatever"
      )
    )

    assert(givenThird.profile.name === "whatever")
  }

  test("Profile data is editable in third") {
    val givenThird = BuildThird.any(
      withThirdProfile = BuildThirdProfile.any(
        withName = "whatever"
      )
    )

    givenThird.profile.name = "something new"

    assert(givenThird.profile.name === "something new")
  }
}
