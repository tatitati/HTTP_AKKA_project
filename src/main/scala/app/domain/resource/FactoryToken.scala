package app.domain.resource

import app.domain.auth.Token
import com.github.nscala_time.time.Imports.DateTime

object FactoryToken {

  def create(): Token = {
      new Token(
        accessToken = java.util.UUID.randomUUID,
        refreshToken = java.util.UUID.randomUUID,
        generatedIn = DateTime.now()
      )
  }
}
