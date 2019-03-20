package test.app.domain.ownerstore

import app.domain.owner.{Auth, Auths}
import builders.domain.{BuildAuth, BuildAuths, BuildThird, BuildThirdCredentials}
import org.scalatest.FunSuite

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

    listmap.removeAuth("clientid2")

    assert(listmap.findAuth("clientid1").isInstanceOf[Some[Auth]])
    assert(listmap.findAuth("clientid2") === None)
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

    listmap.addAuth(auth)

    assert(listmap.findAuth("clientid1").isInstanceOf[Some[Auth]])
    assert(listmap.findAuth("clientid3").isInstanceOf[Some[Auth]])
    assert(listmap.count() === 2)
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

    listmap.addAuth(auth)
    assert(listmap.count() === 3)

    listmap.addAuth(auth)
    assert(listmap.count() === 3)
  }
}
