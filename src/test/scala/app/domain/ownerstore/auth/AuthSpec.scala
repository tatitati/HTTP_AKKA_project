package app.domain.ownerstore.auth

import builders.BuildThird
import builders.authorizes.{BuildAuth, BuildScope}
import org.scalatest.FunSuite

class AuthSpec extends FunSuite {

  test("Can create a permission") {
    val auth = new Auth(
      mementoThird = BuildThird.any().exportMemento(),
        scope = BuildScope.onlySurname()
    )

    assert(auth.isInstanceOf[Auth])
  }

  test("Can tell us some information about what permissions were provided to the third party") {
    val auth = new Auth(
      mementoThird = BuildThird.any().exportMemento(),
      scope = BuildScope.onlySurname()
    )

    assert(auth.canAccessToFirstname() === false)
    assert(auth.canAccessToSurname() === true)
  }

  test("Can tell us basic information about the third") {
    val auth = BuildAuth.any(
      third = BuildThird.any(
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
