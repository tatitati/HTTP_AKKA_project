package app.domain.factories

import app.domain.Token
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
