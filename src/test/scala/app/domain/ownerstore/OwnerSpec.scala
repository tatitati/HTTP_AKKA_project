package app.domain.ownerstore

import app.domain.ownerstore.Owner
import app.domain.ownerstore.authorizations.AuthorizationsList
import builders.BuilderOwner
import builders.authorizes.BuilderAuthorization
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

  test("Has a profile") {
    val user = BuilderOwner.any()

    assert(user.firstname === "any firstname")
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
}
