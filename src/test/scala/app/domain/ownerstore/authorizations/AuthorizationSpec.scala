package app.domain.ownerstore.authorizations

import builders.BuilderThird
import builders.authorizes.BuilderScope
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
}
