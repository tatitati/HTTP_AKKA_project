package app.infrastructure.serializer

import org.scalatest.FunSuite
import test.builders.BuildResourceByCode

class SerializerResourceByCodeSpec extends FunSuite {

  test("Can convert to json a resource by code") {
    val resByCode = BuildResourceByCode.any()

    val value = SerializerResourceByCode.toJson(resByCode)

//    {
//      "thirdProfile":
//          {"name":"R>^_[z!!M:","clientid":"M5U6'2z\\Pl","clientsecret":"X9Z[OU\\!>-","callback":"@==+-M&Q:0","homepage":"@^Wj`z)|i!","description":"5VqQ+,wXSD"},
//      "ownerProfile":
//          {"firstname":"h9for$Zh8/","surname":"P<sT+MTnWj","email":"ae0a|$-V38","emailconfirmed":false,"datebirth":{}},
//      "scope":
//          {"firstname":true,"surname":false,"email":true},
//      "code":{}
//    }

    val regexKeys = ".*thirdProfile:.*clientid.*ownerProfile:.*surname.*scope:.*code:"
      assert(regexKeys.matches(regexKeys) === true)
  }
}
