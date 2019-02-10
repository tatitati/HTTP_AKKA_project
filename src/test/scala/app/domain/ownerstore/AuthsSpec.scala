package app.domain.ownerstore

import builders.{BuildThirdProfile}
import builders.authorizes.{BuildAuth, BuildAuths}
import org.scalatest.FunSuite

class AuthsSpec extends FunSuite {
  test("Builder can create a list of permissions with custom ids") {
    val listmap = BuildAuths.withClientIds("clientid1", "clientid2", "clientid3")
    assert(listmap.count === 3)
  }

  test("can find auth by clientid") {

    val givenAuth1 = BuildAuth.any(
      withThirdProfile = BuildThirdProfile.any(
          withClientid = "clientid1"
      )
    )

    val givenAuthList = new Auths(Vector(givenAuth1))

    val foundAuth1 = givenAuthList.find("clientid1")
    val foundAuth2 = givenAuthList.find("aaaaaaaa")

    assert(foundAuth1.isInstanceOf[Some[Auth]] === true)
    assert(foundAuth2 === None)
  }

  test("Can remove from list") {
    val listmap = BuildAuths.withClientIds("clientid1", "clientid2")

    assert(listmap.find("clientid1") !== None)
    assert(listmap.find("clientid2") !== None)
    listmap.removeThird("clientid2")
    assert(listmap.find("clientid1") !== None)
    assert(listmap.find("clientid2") === None)
  }

  test("Can add to list") {
    val listmap = BuildAuths.withClientIds("clientid1")

    val auth = BuildAuth.any(
        withThirdProfile = BuildThirdProfile.any(
          withClientid = "clientid3"
        )
    )

    assert(listmap.find("clientid1") !== None)
    assert(listmap.find("clientid3") === None)
    assert(listmap.count() === 1)

    listmap.addThird(auth)

    assert(listmap.find("clientid1") !== None)
    assert(listmap.find("clientid3") !== None)
    assert(listmap.count() === 2)
  }

  test("Cannot add twice the same to list") {
    val listmap = BuildAuths.withClientIds("clientid1", "clientid2")

    val auth = BuildAuth.any(
        withThirdProfile = BuildThirdProfile.any(
          withClientid = "clientid3"
        )
    )

    assert(listmap.count() === 2)
    listmap.addThird(auth)
    assert(listmap.count() === 3)
    listmap.addThird(auth)
    assert(listmap.count() === 3)
  }
}
