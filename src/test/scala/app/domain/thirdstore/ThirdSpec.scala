package app.domain.thirdstore

import builders.{BuildResource, BuildThird}
import org.scalatest.FunSuite

class ThirdSpec extends FunSuite {
  
  test("can refresh credentials if they are compromised") {
    val third = BuildThird.any()

    val clientId = third.getclientid
    val clientSecret = third.getclientsecret

    third.refreshCredentials()
  }
}
