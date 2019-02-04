package app.domain.ownerstore

import app.domain.ownerstore.auth.Auth
import builders.{BuilderOwner, BuilderProfile, BuilderThird}
import builders.authorizes.{BuilderAuth, BuilderAuthList, BuilderScope}
import org.scalatest.FunSuite

class OwnerSpec extends FunSuite {

  test("Can be created using a builder") {
    assert(BuilderOwner.any().isInstanceOf[Owner])
  }

  test("Has a list of authorizations ") {
    val user = BuilderOwner.any()

    assert(user.authorizationsList.isInstanceOf[AuthList])
    assert(user.countThirds === 2)
  }

  test("Has an editable profile") {
    val user = BuilderOwner.any(
      profile = BuilderProfile.any(firstname = "gutierrez")
    )

    assert(user.firstname === "gutierrez")
    user.setFirstname("manolo")
    assert(user.firstname === "manolo", "=> Firstname should be updated")
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
    assert(user.has("anyclientid") === false, "=> Authorization should be removed from list")
  }

  test("Can authorize a third") {
    val user = BuilderOwner.any()

    assert(user.has("newthirdclientId") === false, "=> Initially shouldn't have this third in the list")
    assert(user.countThirds() === 2)

    user.grant(
      BuilderAuth.anyAuthorizationWithClientId("newthirdclientId")
    )

    assert(user.has("newthirdclientId") === true, "=> After grant acces it should be in the lsit")
    assert(user.countThirds() === 3)
  }

  test("can provide info about a third in the list") {

    val givenOwner = BuilderOwner.any(authorizationsList = new AuthList(List(
      new Auth(
        BuilderThird.any(name = "travis", clientId = "clientid1"),
        BuilderScope.onlyEmailAndFirstname()
      ),
      BuilderAuth.any(),
      BuilderAuth.any(),
    )))

    val auth1 = givenOwner.find("clientid1")

    assert(auth1.isInstanceOf[Some[Auth]] === true)
    assert(auth1 match {
        case Some(value) => value.name === "travis"
        case _ => false
    })

    val auth2 = givenOwner.find("aaasadsfasdf")
    assert(auth2 === None )
  }
}
