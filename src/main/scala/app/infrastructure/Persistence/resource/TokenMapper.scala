package app.infrastructure.Persistence.resource

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
}
