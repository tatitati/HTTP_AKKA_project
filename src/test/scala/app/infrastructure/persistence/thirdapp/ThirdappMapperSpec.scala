package app.infrastructure.persistence.thirdapp

import org.scalatest.FunSuite
import test.app.domain.model.thirdapp.BuildThirdapp

class ThirdappMapperSpec extends FunSuite {

  test("I can map from domain to persistent model") {
    val givenDomain = BuildThirdapp.any()

    val thenPersistent = ThirdappMapper.toPersistent(givenDomain)

    assert(thenPersistent.isInstanceOf[ThirdappPersistentModel])
  }
}
