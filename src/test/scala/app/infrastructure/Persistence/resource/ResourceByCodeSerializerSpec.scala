package test.app.infrastructure.Persistence.resource

import app.infrastructure.Persistence.resource.ResourceByCodeSerializer
import builders.domain.BuildResourceByCode
import org.scalatest.FunSuite

class ResourceByCodeSerializerSpec extends FunSuite {

  test("Can serialize an specific object") {
    val resByCode = BuildResourceByCode.specific()

    val inJson = ResourceByCodeSerializer.toJson(resByCode)

    assert(inJson ===
      """{"third":{
          |"id":22,
          |"name":"whatever",
          |"clientid":"client_id",
          |"clientsecret":"client_secret",
          |"callback":"callback",
          |"homepage":"homepage",
          |"description":"my description"
        |},
        |"ownerProfile":{
          |"firstname":"firstname",
          |"surname":"surname",
          |"email":"email",
          |"emailconfirmed":true,
          |"datebirth":"1900-03-10T00:00:00.000Z"
        |},
        |"scope":{
          |"firstname":true,
          |"surname":false,
          |"email":true
        |},
        |"code":{
          |"code":"code",
          |"expiresIn":10,
          |"generatedIn":"2015-02-10T00:00:00.000Z",
          |"state":"state"
        |}
        |}""".stripMargin.replaceAll("\n", ""))
  }

  test("Can deserialize an specific json") {

    val givenJson =
      """{
        |"third":{
          |"id":22,
          |"name":"whatever",
          |"clientid":"client_id",
          |"clientsecret":"client_secret",
          |"callback":"callback",
          |"homepage":"homepage",
          |"description":"my description"
        |},
        |"ownerProfile":{
          |"firstname":"firstname",
          |"surname":"surname",
          |"email":"email",
          |"emailconfirmed":true,
          |"datebirth":"1900-03-10T00:00:00.000Z"
        |},
        |"scope":{
          |"firstname":true,
          |"surname":false,
          |"email":true
        |},
        |"code":{
          |"code":"code",
          |"expiresIn":10,
          |"generatedIn":"2015-02-10T00:00:00.000Z",
          |"state":"state"
        |}
        |}""".stripMargin.replaceAll("\n", "")


    val resByCode = ResourceByCodeSerializer.toDomain(givenJson)

    assert(resByCode.memento() === BuildResourceByCode.specific().memento())
  }

  test("No data is lost in both processes") {
    val resByCode = BuildResourceByCode.specific()
    val inJson = ResourceByCodeSerializer.toJson(resByCode)
    val fromJson = ResourceByCodeSerializer.toDomain(inJson)

    assert(resByCode.memento() === fromJson.memento())
  }
}
