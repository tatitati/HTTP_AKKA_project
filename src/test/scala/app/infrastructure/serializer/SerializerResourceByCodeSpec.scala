package app.infrastructure.serializer

import org.scalatest.FunSuite
import test.builders.BuildResourceByCode

class SerializerResourceByCodeSpec extends FunSuite {

  test("Can serialize an specific object") {
    val resByCode = BuildResourceByCode.specific()

    val inJson = SerializerResourceByCode.toJson(resByCode)

    assert(inJson ===
      """{"thirdProfile":{
          |"name":"name",
          |"clientid":"clientid",
          |"clientsecret":"clientsecret",
          |"callback":"callback",
          |"homepage":"homepage",
          |"description":"description"
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
        |"thirdProfile":{
          |"name":"name",
          |"clientid":"clientid",
          |"clientsecret":"clientsecret",
          |"callback":"callback",
          |"homepage":"homepage",
          |"description":"description"
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


    val resByCode = SerializerResourceByCode.toDomain(givenJson)

    val memento1 = resByCode.exportMemento()
    val memento2 = BuildResourceByCode.specific().exportMemento()

    assert(memento1 === memento2)
  }

  test("No data is lost in both processes") {
    val resByCode = BuildResourceByCode.specific()
    val inJson = SerializerResourceByCode.toJson(resByCode)
    val fromJson = SerializerResourceByCode.toDomain(inJson)

    val mementoFromOriginal = resByCode.exportMemento()
    val mementoFromParsed = fromJson.exportMemento()

    assert(mementoFromParsed === mementoFromOriginal)
  }
}
