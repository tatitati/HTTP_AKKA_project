package app.domain.ownerstore

import app.domain.ownerstore.authorizations.{Authorization, AuthorizationsList}
import builders.{BuilderOwner, BuilderProfile, BuilderThird}
import builders.authorizes.{BuilderAuthorization, BuilderAuthorizationsList, BuilderScope}
import org.scalatest.FunSuite

class OwnerSpec extends FunSuite {

  test("Can be created using a builder") {
    assert(BuilderOwner.any().isInstanceOf[Owner])
  }

  test("Has a list of authorizations ") {
    val user = BuilderOwner.any()

    assert(user.authorizationsList.isInstanceOf[AuthorizationsList])
    assert(user.countThirds === 2)
  }

  test("Has an editable profile") {
    val user = BuilderOwner.any(
      profile = BuilderProfile.any(firstname = "gutierrez")
    )

    assert(user.firstname === "gutierrez")
    user.firstname = "manolo"
    assert(user.firstname === "manolo")
  }

  test("Know if a third is authorized") {
    val user = BuilderOwner.any()

    assert(user.has("anyclientid") === true)
    assert(user.has("anycountid") === false)
  }

  test("Can revoke thirds") {
    val user = BuilderOwner.any()

    assert(user.has("anyclientid") === true)
    user.revoke("anyclientid")
    assert(user.has("anyclientid") === false)
  }

  test("Can authorize a third") {
    val user = BuilderOwner.any()

    assert(user.has("newthirdclientId") === false)
    assert(user.countThirds() === 2)

    val mapThirdToperm = BuilderAuthorization.anyAuthorizationWithClientId("newthirdclientId")
    user.grant(mapThirdToperm)

    assert(user.has("newthirdclientId") === true)
    assert(user.countThirds() === 3)
  }

//  test("can get scope given to a third") {
//    val givenAuthorization1 = new Authorization(
//      BuilderThird.anyWithClientId("clientid1"),
//      BuilderScope.onlyEmailAndFirstname()
//    )
//
//    val givenAuthorization2 = new Authorization(
//      BuilderThird.anyWithClientId("clientid2"),
//      BuilderScope.onlySurname()
//    )
//
//    val givenOwner = BuilderOwner.any(authorizationsList = new AuthorizationsList(List(givenAuthorization1, givenAuthorization2)))
//
//    val scope = givenOwner.getscope("clientid1")
//
//
//
//  }
}
