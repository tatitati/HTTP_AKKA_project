package app.infrastructure.Persistence.resource

import app.domain.auth.BuildToken
import org.scalatest.FunSuite

class TokenMapperToPersistedSpec extends FunSuite {
    test("Domain token can be mapped to persisted") {
      val givenDomainToken = BuildToken.anyLive()
      val persistedModel = TokenMapper.toPersistence(givenDomainToken)

      assert(persistedModel.isInstanceOf[TokenPersistentModel])
      assert(persistedModel.tokenType === "bearer")
    }

    test("Surrogate id is also mapped to persisted domain") {
      val givenDomainToken = BuildToken.anyLive(withSurrogateId = Some(12))
      val persistedModel = TokenMapper.toPersistence(givenDomainToken)

      assert(persistedModel.id === Some(12))
    }

  test("Surrogate id is also mapped when is None") {
    val givenDomainToken = BuildToken.anyLive(withSurrogateId = None)
    val persistedModel = TokenMapper.toPersistence(givenDomainToken)

    assert(persistedModel.id === None)
  }
}
