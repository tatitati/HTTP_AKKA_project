package app.domain.ownerstore.authorization

import builders.BuilderThird
import builders.authorizes.{BuilderAuthorization, BuilderScope}
import org.scalatest.FunSuite

class AuthorizationSpec extends FunSuite {

  test("Can create a permission") {
    val apppermision = new Authorization(
        third = BuilderThird.any(),
        scope = BuilderScope.onlySurname()
    )

    assert(apppermision.isInstanceOf[Authorization])
  }

  test("Can tell us some information about what permissions were provided to the third party") {
    val apppermision = new Authorization(
      third = BuilderThird.any(),
      scope = BuilderScope.onlySurname()
    )

    assert(apppermision.canAccessToFirstname() === false)
    assert(apppermision.canAccessToSurname() === true)
  }

  test("Can tell us basic information about the third") {
    val auth = BuilderAuthorization.any(
      third = BuilderThird.any(
        name = "CircleCI",
        homepage = "http://www.whatever.com",
        clientId = "myclientid"
      )
    )

    assert(auth.name == "CircleCI")
    assert(auth.homepage == "http://www.whatever.com")
    assert(auth.clientId == "myclientid")
  }
}
