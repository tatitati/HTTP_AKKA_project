package app.domain.model.auth

import java.util.UUID

import app.domain.model.IdentifiableInPersistence
import app.domain.model.user.UserId
import app.domain.model.third.ThirdId
import com.github.nscala_time.time.Imports.DateTime

class Auth(
      val id: AuthId,
      private val thirdId: ThirdId,
      private val userId: UserId,
      private val scope: AuthScope,
      private var token: Token
  ) extends IdentifiableInPersistence {

  def equals(auth: Auth): Boolean = {
    id.equals(auth.id)
  }

  def canReadFirstname: Boolean = token.isLive match {
    case true => scope.firstname
    case _ => false
  }

  def canReadSurname: Boolean = token.isLive match {
    case true => scope.surname
    case _ => false
  }

  def canReadEmail: Boolean = token.isLive match {
    case true => scope.email
    case _ => false
  }

  def getToken: Token = {
    token
  }

  def refreshToken(refreshToken: UUID, grantType: String): Unit = {
    if(token.canBeRefreshed(refreshToken, grantType)) {
      token = new Token(
        accessToken = java.util.UUID.randomUUID,
        tokenType = "bearer",
        refreshToken = java.util.UUID.randomUUID,
        expiresIn = 60,
        generatedIn = DateTime.now()
      )
    }
  }
}
