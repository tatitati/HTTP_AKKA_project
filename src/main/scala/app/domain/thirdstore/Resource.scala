package app.domain.thirdstore

import java.util.UUID

import app.domain.{Scope, Token}
import app.domain.ownerstore.OwnerProfile
import com.github.nscala_time.time.Imports.DateTime

class Resource(
                private val ownerProfile: OwnerProfile,
                private val scope: Scope,
                var token: Option[Token]
    ){

    @throws(classOf[IllegalAccessException])
    def firstname(): String =
      scope.firstname match {
        case true if !isExpired => ownerProfile.firstname
        case true if isExpired => throw new IllegalAccessException("The scope allows to access this property. However your token is expired and need to be refreshed")
        case _ => throw new IllegalAccessException("The scope doesn't allow you to access to firstname")
    }

    @throws(classOf[IllegalAccessException])
    def surname(): String = {
        scope.surname match {
          case true if !isExpired => ownerProfile.surname
          case true if isExpired => throw new IllegalAccessException("The scope allows to access this property. However your token is expired and need to be refreshed")
          case _ => throw new IllegalAccessException("The scope doesn't allow you to access to surname")
        }
    }

    @throws(classOf[IllegalAccessException])
    def email(): String = scope.email match {
        case true if !isExpired => ownerProfile.email
        case true if isExpired => throw new IllegalAccessException("The scope allows to access this property. However your token is expired and need to be refreshed")
        case _ => throw new IllegalAccessException("The scope doesn't allow you to access to email")
    }

    @throws(classOf[IllegalAccessException])
    def isExpired(): Boolean = token match {
        case Some(token) => token.isExpired
        case _ => throw new IllegalAccessException("There is no token. Cannot be possible to know if is expired.")
    }

    def refreshToken(withRefreshToken: UUID, withGrantType: String): Unit = {
      var currentToken = token match {
        case Some(token) => token
        case None => throw new IllegalAccessException("There is no token to refresh. The token doesn't exist")
      }

      if(!currentToken.canRefreshWithParams(withRefreshToken, withGrantType)) {
        throw new IllegalAccessException("The parameters used to refresh the token are invalid.")
      }

      if (!currentToken.isExpired) {
        throw new IllegalAccessException("The token must be expired in order to be refreshed")
      }

      token = Some(new Token(
        accessToken = java.util.UUID.randomUUID,
        refreshToken = java.util.UUID.randomUUID,
        generatedIn = DateTime.now(),
        tokenType = "bearer"
      )
      )
    }

    def revoke(): Unit = {
      token = token match {
        case Some(token) => None
        case None => throw new IllegalAccessException("There is no token, so it cannot be revoked.")
      }
    }
}
