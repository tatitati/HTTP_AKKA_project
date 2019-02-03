package app.domain.ownerstore.authorizations

import builders.authorizes.{BuilderAuthorization, BuilderAuthorizationsList}
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

  test("Can check if a third party was granted any kind of access (is in the list)") {
    val listmap = BuilderAuthorizationsList.any()

    assert(listmap.existThird("anyclientid") === true)
    assert(listmap.existThird("clientId2") === false)
  }


  test("Can revoke") {
    val listmap = BuilderAuthorizationsList.anyListWithClientIds(List("clientid1", "clientid2", "clientid3"))

    assert(listmap.existThird("clientid1") === true)
    assert(listmap.existThird("clientid2") === true)
    assert(listmap.existThird("clientid3") === true)
    listmap.removeThird("clientid2")
    assert(listmap.existThird("clientid1") === true)
    assert(listmap.existThird("clientid2") === false)
    assert(listmap.existThird("clientid3") === true)
  }

  test("Can grant") {
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

  test("Cannot grant twice the same client id") {
    val listmap = BuilderAuthorizationsList.anyListWithClientIds(List("clientid1", "clientid2"))

    val third = BuilderAuthorization.anyAuthorizationWithClientId("clientid3")

    assert(listmap.count() === 2)
    listmap.addThird(third)
    assert(listmap.count() === 3)
    listmap.addThird(third)
    assert(listmap.count() === 3)
  }
}
