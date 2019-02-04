package app.domain.ownerstore

import app.domain.ownerstore.auth.Auth
import builders.BuilderThird
import builders.authorizes.{BuilderAuth, BuilderAuthList, BuilderScope}
import org.scalatest.FunSuite

class AuthListSpec extends FunSuite {
  test("Builder can create a list of AppPermissions") {
    assert(BuilderAuthList.any().count === 2)
  }

  test("Builder can create a list of permissions with custom ids") {
    val listmap = BuilderAuthList.anyListWithClientIds(List("clientid1", "clientid2", "clientid3"))
    assert(listmap.count === 3)

  }

  test("Can know if exist an item in list") {
    val listmap = BuilderAuthList.any()

    assert(listmap.existThird("anyclientid") === true)
    assert(listmap.existThird("clientId2") === false)
  }

  test("can find item by clientid") {
    val givenAuthorization1 = new Auth(
      BuilderThird.anyWithClientId("clientid1"),
      BuilderScope.onlyEmailAndFirstname()
    )

    val givenAuthorization2 = new Auth(
      BuilderThird.anyWithClientId("clientid2"),
      BuilderScope.onlySurname()
    )

    val authList = new AuthList(List(givenAuthorization1, givenAuthorization2))
    val scope1 = authList.find("clientid1")
    assert(scope1.isInstanceOf[Some[Auth]] === true)

    val scope2 = authList.find("aaaaaaaa")
    assert(scope2 === None)
  }

  test("Can remove from list") {
    val listmap = BuilderAuthList.anyListWithClientIds(List("clientid1", "clientid2", "clientid3"))

    assert(listmap.existThird("clientid1") === true)
    assert(listmap.existThird("clientid2") === true)
    assert(listmap.existThird("clientid3") === true)
    listmap.removeThird("clientid2")
    assert(listmap.existThird("clientid1") === true)
    assert(listmap.existThird("clientid2") === false)
    assert(listmap.existThird("clientid3") === true)
  }

  test("Can add to list") {
    val listmap = BuilderAuthList.anyListWithClientIds(List("clientid1", "clientid2"))

    val third = BuilderAuth.anyAuthorizationWithClientId("clientid3")

    assert(listmap.existThird("clientid1") === true)
    assert(listmap.existThird("clientid2") === true)
    assert(listmap.existThird("clientid3") === false)
    listmap.addThird(third)
    assert(listmap.existThird("clientid1") === true)
    assert(listmap.existThird("clientid2") === true)
    assert(listmap.existThird("clientid3") === true)

    assert(listmap.count() === 3)
  }

  test("Cannot add twice the same to list") {
    val listmap = BuilderAuthList.anyListWithClientIds(List("clientid1", "clientid2"))

    val third = BuilderAuth.anyAuthorizationWithClientId("clientid3")

    assert(listmap.count() === 2)
    listmap.addThird(third)
    assert(listmap.count() === 3)
    listmap.addThird(third)
    assert(listmap.count() === 3)
  }
}
