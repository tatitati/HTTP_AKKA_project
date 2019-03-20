package app.infrastructure.Persistence.resource

import java.util.UUID

import app.domain.resource.Token

object TokenMapper {
  def toPersistence(token: Token): TokenPersistentModel = {
    TokenPersistentModel(
        id = token.getSurrogateId(),
        accessToken = token.accessToken.toString,
        tokenType = token.tokenType,
        refreshToken = token.refreshToken.toString,
        expiresIn = token.expiresIn,
        generatedIn = token.generatedIn
    )
  }

  def toDomain(persisted: TokenPersistentModel): Token = {
    val token = new Token(
      accessToken = UUID.fromString(persisted.accessToken),
      tokenType = persisted.tokenType,
      refreshToken = UUID.fromString(persisted.refreshToken),
      expiresIn = persisted.expiresIn,
      generatedIn = persisted.generatedIn
    )

    persisted.id match {
      case None => throw new IllegalArgumentException("A persisted token is expected to have an id in order to be mapped to domain")
      case Some(value) if value.isInstanceOf[Long] => token.setSurrogateId(persisted.id)
    }

    token
  }
}
