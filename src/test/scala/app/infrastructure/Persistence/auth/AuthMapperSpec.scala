package test.app.infrastructure.Persistence.auth

import app.domain.model.auth.Auth
import app.infrastructure.Persistence.auth.{AuthMapper, AuthPersistentModel, BuildAuthPersistentModel}
import org.scalatest.FunSuite
import test.app.domain.model.auth.BuildAuth

class AuthMapperSpec extends FunSuite {

  test("Can map from domain to persistent") {
    val inDomain = BuildAuth.specific()

    val persistent = AuthMapper.toPersistent(inDomain)

    assert(persistent.isInstanceOf[AuthPersistentModel])
    assert(persistent.scopeEmail === true)
    assert(persistent.scopeSurname === false)
  }

  test("Can map from persistent to domain") {
    val persistent = BuildAuthPersistentModel.any()

    val inDomain = AuthMapper.toDomain(persistent)

    assert(inDomain.isInstanceOf[Auth])

  }
}
