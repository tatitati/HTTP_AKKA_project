package app.domain.ownerstore

import builders.BuildThird
import builders.authorizes.{BuildAuth, BuildScope}
import org.scalatest.FunSuite

class AuthSpec extends FunSuite {

  test("Can create a permission") {
    val auth = new Auth(
      third = BuildThird.any(),
      scope = BuildScope.onlySurname()
    )

    assert(auth.isInstanceOf[Auth])
  }

  test("Can tell us some information about what permissions were provided to the third party") {
    val auth = new Auth(
      third = BuildThird.any(),
      scope = BuildScope.onlySurname()
    )

    assert(auth.canAccessToFirstname() === false, "=> Third should be able to access to firstname")
    assert(auth.canAccessToSurname() === true, "=> Third should be able to access to surname")
  }

  test("The owner only can see name, homepage and description about the third") {
    val auth = BuildAuth.any(
      third = BuildThird.any(
        name = "CircleCI",
        homepage = "http://www.whatever.com",
        description = "any description"
      )
    )

    assert(auth.name == "CircleCI")
    assert(auth.homepage == "http://www.whatever.com")
    assert(auth.description == "any description")
  }
}
