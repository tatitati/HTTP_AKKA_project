package test.app.domain.ownerstore

import app.domain.owner.{Auth, Auths}
import builders.authorizes.BuildAuths
import org.scalatest.FunSuite
import test.builders.{BuildThird, BuildThirdCredentials, BuildThirdProfile}
import test.builders.authorizes.BuildAuth

class AuthsSpec extends FunSuite {
  test("Builder can create a list of permissions with custom ids") {
    val listmap = BuildAuths.withClientIds("clientid1", "clientid2", "clientid3")
    assert(listmap.count === 3)
  }

  test("can find auth by clientid") {

    val givenAuth1 = BuildAuth.any(
      withThird = BuildThird.any(
        withCredentials = BuildThirdCredentials.any(
          withClientid = "clientid1"
        )
      )
    )

    val givenAuthList = new Auths(Vector(givenAuth1))

    val foundAuth1 = givenAuthList.findAuth("clientid1")
    val foundAuth2 = givenAuthList.findAuth("aaaaaaaa")

    assert(foundAuth1.isInstanceOf[Some[Auth]])
    assert(foundAuth2 === None)
  }

  test("Can remove from list") {
    val listmap = BuildAuths.withClientIds("clientid1", "clientid2")

    assert(listmap.findAuth("clientid1").isInstanceOf[Some[Auth]])
    assert(listmap.findAuth("clientid2").isInstanceOf[Some[Auth]])

    val listUpdated = listmap.removeAuth("clientid2")

    assert(listUpdated.findAuth("clientid1").isInstanceOf[Some[Auth]])
    assert(listUpdated.findAuth("clientid2") === None)
  }

  test("Can add to list") {
    val listmap = BuildAuths.withClientIds("clientid1")

    val auth = BuildAuth.any(
      withThird = BuildThird.any(
        withCredentials = BuildThirdCredentials.any(
          withClientid = "clientid3"
        )
      )
    )

    assert(listmap.findAuth("clientid1").isInstanceOf[Some[Auth]])
    assert(listmap.findAuth("clientid3") === None)
    assert(listmap.count() === 1)

    val listUpdated = listmap.addAuth(auth)

    assert(listUpdated.findAuth("clientid1").isInstanceOf[Some[Auth]])
    assert(listUpdated.findAuth("clientid3").isInstanceOf[Some[Auth]])
    assert(listUpdated.count() === 2)
  }

  test("Cannot add twice the same to list") {
    val listmap = BuildAuths.withClientIds("clientid1", "clientid2")

    val auth = BuildAuth.any(
      withThird = BuildThird.any(
        withCredentials = BuildThirdCredentials.any(
          withClientid = "clientid3"
        )
      )
    )

    assert(listmap.count() === 2)

    val listUpdated = listmap.addAuth(auth)
    assert(listUpdated.count() === 3)

    val listUpdated2 = listUpdated.addAuth(auth)
    assert(listUpdated2.count() === 3)
  }
}
