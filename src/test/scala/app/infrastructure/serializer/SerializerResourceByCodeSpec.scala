//package app.infrastructure.serializer
//
//import org.scalatest.FunSuite
//import test.builders.BuildResourceByCode
//
//class SerializerResourceByCodeSpec extends FunSuite {
//  test("Can one specific") {
//    val resByCode = BuildResourceByCode.specific()
//
//    val inJson = SerializerResourceByCode.toJson(resByCode)
//
//    assert(inJson ===
//      """{
//          |"thirdProfile":{
//              |"name":"name",
//              |"clientid":"clientid",
//              |"clientsecret":"clientsecret",
//              |"callback":"callback",
//              |"homepage":"homepage",
//              |"description":"description"
//          |},
//          |"ownerProfile":{
//              |"firstname":"firstname",
//              |"surname":"surname",
//              |"email":"email",
//              |"emailconfirmed":true,
//              |"datebirth":{}
//          |},
//          |"scope":{
//              |"firstname":true,
//              |"surname":false,
//              |"email":true
//          |},
//          |"code":{
//              |"code":"code",
//              |"expiresIn":10,
//              |"generatedIn":{},
//              |"state":"state"
//          |}
//        |}""".stripMargin.replaceAll("\n", ""))
//  }
//}
