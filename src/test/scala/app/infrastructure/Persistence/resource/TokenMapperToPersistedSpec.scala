package app.infrastructure.Persistence.resource

import builders.domain.{BuildSurrogateId, BuildToken}
import org.scalatest.FunSuite

class TokenMapperToPersistedSpec extends FunSuite {
    test("Domain token can be mapped to persisted") {
      var givenDomainToken = BuildToken.anyLive()
      var persistedModel = TokenMapper.toPersistence(givenDomainToken)

      assert(persistedModel.isInstanceOf[TokenPersistentModel])
      assert(persistedModel.tokenType === "bearer")
    }

    test("Surrogate id is also mapped to persisted domain") {
      var givenDomainToken = BuildToken.anyLive(withSurrogateId = Some(12))
      var persistedModel = TokenMapper.toPersistence(givenDomainToken)

      assert(persistedModel.id === Some(12))
    }

  test("Surrogate id is also mapped when is None") {
    var givenDomainToken = BuildToken.anyLive(withSurrogateId = None)
    var persistedModel = TokenMapper.toPersistence(givenDomainToken)

    assert(persistedModel.id === None)
  }
}
