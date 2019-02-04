package app.domain.ownerstore

import app.domain.ownerstore.authorization.Authorization
import builders.BuilderThird
import builders.authorizes.{BuilderAuthorization, BuilderAuthorizationsList, BuilderScope}
import org.scalatest.FunSuite

class AuthorizationListSpec extends FunSuite {
  test("Builder can create a list of AppPermissions") {
    assert(
      BuilderAuthorizationsList.any().count === 2
    )
  }

  test("Builder can create a list of permissions with custom ids") {
    val listmap = BuilderAuthorizationsList.anyListWithClientIds(List("clientid1", "clientid2", "clientid3"))
    assert(
      listmap.count === 3
    )

  }

  test("Can know if exist an item in list") {
    val listmap = BuilderAuthorizationsList.any()

    assert(listmap.existThird("anyclientid") === true)
    assert(listmap.existThird("clientId2") === false)
  }

  test("can find item by clientid") {
    val givenAuthorization1 = new Authorization(
      BuilderThird.anyWithClientId("clientid1"),
      BuilderScope.onlyEmailAndFirstname()
    )

    val givenAuthorization2 = new Authorization(
      BuilderThird.anyWithClientId("clientid2"),
      BuilderScope.onlySurname()
    )

    val authList = new AuthorizationsList(List(givenAuthorization1, givenAuthorization2))
    val scope1 = authList.find("clientid1")
    assert(scope1.isInstanceOf[Some[Authorization]] === true)

    val scope2 = authList.find("aaaaaaaa")
    assert(scope2 === None)
  }

  test("Can remove from list") {
    val listmap = BuilderAuthorizationsList.anyListWithClientIds(List("clientid1", "clientid2", "clientid3"))

    assert(listmap.existThird("clientid1") === true)
    assert(listmap.existThird("clientid2") === true)
    assert(listmap.existThird("clientid3") === true)
    listmap.removeThird("clientid2")
    assert(listmap.existThird("clientid1") === true)
    assert(listmap.existThird("clientid2") === false)
    assert(listmap.existThird("clientid3") === true)
  }

  test("Can add to list") {
    val listmap = BuilderAuthorizationsList.anyListWithClientIds(List("clientid1", "clientid2"))

    val third = BuilderAuthorization.anyAuthorizationWithClientId("clientid3")

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
    val listmap = BuilderAuthorizationsList.anyListWithClientIds(List("clientid1", "clientid2"))

    val third = BuilderAuthorization.anyAuthorizationWithClientId("clientid3")

    assert(listmap.count() === 2)
    listmap.addThird(third)
    assert(listmap.count() === 3)
    listmap.addThird(third)
    assert(listmap.count() === 3)
  }
}
