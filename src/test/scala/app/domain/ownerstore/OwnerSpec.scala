package app.domain.ownerstore

import builders.{BuildOwner, BuildOwnerProfile, BuildThird}
import builders.authorizes.{BuildAuth, BuildScope}
import org.scalatest.FunSuite

class OwnerSpec extends FunSuite {

  test("Can be created using a builder") {
    assert(BuildOwner.any().isInstanceOf[Owner])
  }

  test("Has a list of authorizations ") {
    val givenUser = BuildOwner.any()

    assert(givenUser.listAuth.isInstanceOf[ListAuth])
    assert(givenUser.countThirds === 2)
  }

  test("Has an editable profile") {
    val givenUser = BuildOwner.any(
      withProfile = BuildOwnerProfile.any(
        withFirstname = "gutierrez"
      )
    )

    assert(givenUser.profile.firstname === "gutierrez")
    givenUser.profile.firstname = "manolo"
    assert(givenUser.profile.firstname === "manolo", "=> Firstname should be updated")
  }

  test("Know if a third is in the list (search by clientid)") {
    val givenUser = BuildOwner.any()

    assert(givenUser.has("anyclientid") === true)
    assert(givenUser.has("anotherclientid") === false)
  }

  test("Can delete(revoke) a third from the list") {
    val givenUser = BuildOwner.any()

    assert(givenUser.has("anyclientid") === true)
    givenUser.revoke("anyclientid")
    assert(givenUser.has("anyclientid") === false, "=> Authorization should be removed from list")
  }

  test("Can authorize a third (add to the list)") {
    val givenUser = BuildOwner.any()

    assert(givenUser.has("newthirdclientId") === false, "=> Initially shouldn't have this third in the list")
    assert(givenUser.countThirds() === 2)

    givenUser.grant(
      BuildAuth.any(
        withThird = BuildThird.any(
          withClientId = "newthirdclientId"
        )
      )
    )

    assert(givenUser.has("newthirdclientId") === true, "=> After grant acces it should be in the lsit")
    assert(givenUser.countThirds() === 3)
  }

  test("can provide info about a third in the list") {

    val givenOwner = BuildOwner.any(
      withAuthorizationsList = new ListAuth(List(
        BuildAuth.any(
          withThird = BuildThird.any(withName = "travis", withClientId = "clientid1"),
          withScope = BuildScope.onlyEmailAndFirstname()
        ),
        BuildAuth.any(),
        BuildAuth.any(),
      )
    ))

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
