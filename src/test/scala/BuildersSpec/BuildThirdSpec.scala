package BuildersSpec

import app.domain.thirdstore.Third
import builders.BuildThird
import org.scalatest.FunSuite

class BuildThirdSpec extends FunSuite {
  test("Builder can create a user") {
    assert(BuildThird.any().isInstanceOf[Third])
  }

  test("Profile data is accessible in the third") {
    val third = BuildThird.any(withName="whatever")

    assert(third.profile.name === "whatever")
  }

  test("Profile data is editable in third") {
    val third = BuildThird.any(withName="whatever")

    third.profile.name = "something new"

    assert(third.profile.name === "something new")
  }
}
