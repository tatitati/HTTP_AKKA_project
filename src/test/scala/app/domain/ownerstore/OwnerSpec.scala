package app.domain.ownerstore

import builders.{BuildOwner, BuildOwnerProfile, BuildThirdProfile}
import builders.authorizes.{BuildAuth, BuildAuths}
import org.scalatest.FunSuite

class OwnerSpec extends FunSuite {

  test("Has a list of authorizations ") {
    val givenUser = BuildOwner.any()

    assert(givenUser.listAuth.isInstanceOf[Auths])
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
    assert(givenUser.profile.firstname === "manolo")
  }

  test("Can delete(revoke) a third from the list") {
    val givenUser = BuildOwner.any(
      withAuths = BuildAuths.withClientIds("anyclientid1", "anyclientid2")
    )

    assert(givenUser.exists("anyclientid1") === true)
    assert(givenUser.exists("anyclientid2") === true)
    givenUser.revoke("anyclientid1")
    assert(givenUser.exists("anyclientid1") === false)
    assert(givenUser.exists("anyclientid2") === true)
  }

  test("Can authorize a third (add to the list)") {
    val givenUser = BuildOwner.any()

    assert(givenUser.exists("newthirdclientId") === false, "=> Initially shouldn't have this third in the list")
    assert(givenUser.countThirds() === 2)

    givenUser.grant(
      BuildAuth.any(
          withThirdProfile = BuildThirdProfile.any(
            withClientid = "newthirdclientId"
          )
      )
    )

    assert(givenUser.exists("newthirdclientId") === true, "=> After grant acces it should be in the lsit")
    assert(givenUser.countThirds() === 3)
  }

  test("can provide info about a third in the list when found") {

    val givenOwner = BuildOwner.any(
      withAuths = new Auths(Vector(
        BuildAuth.any(
            withThirdProfile = BuildThirdProfile.any(
              withClientid = "clientid1",
              withName = "travis"
            )
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
