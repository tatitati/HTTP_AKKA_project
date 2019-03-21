package app.domain.third

import java.util.UUID

import builders.domain.{BuildThird, BuildThirdProfile, BuildUuid}
import org.scalatest.FunSuite

class ThirdSpec extends FunSuite {

  test("Identifier UUID the proper type") {
    val third = BuildThird.any()

    assert(third.Uuid.isInstanceOf[UUID] === true)
  }

  test("Equals use the key to compare") {
    val third1 = BuildThird.any(
      withUUID = BuildUuid.uuidOne()
    )

    val third2 = BuildThird.any(
      withUUID = BuildUuid.uuidTwo()
    )

    val third3 = BuildThird.any(
      withUUID = BuildUuid.uuidTwo()
    )

    assert(third1.equals(third2) === false)
    assert(third2.equals(third3) === true)
  }

  test("can edit third basic profile") {
    val givenThird = BuildThird.any(
      withThirdProfile = BuildThirdProfile.any(
        withName = "first name"
      )
    )

    givenThird.updateName("second name")

    assert(givenThird.getProfile.name === "second name")
  }

  test("can refresh third credentials if they are compromised") {
    val givenThird = BuildThird.any()
    val credentialsOriginal = givenThird.getCredentials

    givenThird.refreshCredentials()

    val credentialsUpdated = givenThird.getCredentials

    assert(credentialsOriginal !== credentialsUpdated)
  }
}
