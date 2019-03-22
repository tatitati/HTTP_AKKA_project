package test.app.domain.ownerstore

import app.domain.auth.Auth
import app.domain.owner.{Auths, AuthsMemento}
import builders.domain._
import org.scalatest.FunSuite

class OwnerOnAuthsSpec extends FunSuite {

  test("It returns a memento with an immutable list of Oauth, to avoid modifications from outside") {
    val givenUser = BuildOwner.any()

    givenUser.getListAuths.isInstanceOf[AuthsMemento]
    assert(givenUser.countThirds === 2)
  }

  test("Can delete(revoke) a third from the list") {
    val givenUser = BuildOwner.any(
      withAuths = BuildAuths.withClientIds("anyclientid1", "anyclientid2")
    )

    assert(givenUser.find("anyclientid1") !== None)
    assert(givenUser.find("anyclientid2") !== None)

    givenUser.revoke("anyclientid1")

    assert(givenUser.find("anyclientid1") === None)
    assert(givenUser.find("anyclientid2") !== None)
  }

  test("Can authorize a third (add to the list)") {
    val givenUser = BuildOwner.any()

    assert(givenUser.find("newthirdclientId") === None, "=> Initially shouldn't have this third in the list")
    assert(givenUser.countThirds() === 2)

    givenUser.grant(
      BuildAuth.any(
        withThird = BuildThird.any(
          withCredentials = BuildThirdCredentials.any(
            withClientid = "newthirdclientId"
          )
        )
      )
    )

    assert(givenUser.find("newthirdclientId") !== None, "=> After grant acces it should be in the lsit")
    assert(givenUser.countThirds() === 3)
  }

  test("can provide info about a third in the list when found") { // this test is a mess

    val givenOwner = BuildOwner.any(
      withAuths = new Auths(Vector(
        BuildAuth.any(
          withThird = BuildThird.any(
            withCredentials = BuildThirdCredentials.any(
              withClientid = "clientid1"
            ),
            withThirdProfile = BuildThirdProfile.any(
              withName = "travis"
            )
          )
        ),
        BuildAuth.any(),
        BuildAuth.any(),
      )
      ))

    val auth1 = givenOwner.find("clientid1")

    assert(auth1.isInstanceOf[Some[Auth]] === true)
    assert(auth1 match {
      case Some(value) => value.getThirdProfile.name === "travis"
      case _ => false
    })

    val auth2 = givenOwner.find("aaasadsfasdf")
    assert(auth2 === None )
  }
}
