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
        case true if !isExpired.getOrElse(false) => ownerProfile.firstname
        case _ => throw new IllegalAccessException("The scope doesn't allow you to access to firstname")
    }

    @throws(classOf[IllegalAccessException])
    def surname(): String = {
        scope.surname match {
          case true if !isExpired.getOrElse(false) => ownerProfile.surname
          case _ => throw new IllegalAccessException("The scope doesn't allow you to access to surname")
        }
    }

    @throws(classOf[IllegalAccessException])
    def email(): String = scope.email match {
        case true if !isExpired.getOrElse(false) => ownerProfile.email
        case _ => throw new IllegalAccessException("The scope doesn't allow you to access to email")
    }

    def isExpired(): Option[Boolean] = token match {
        case Some(token) => Option(token.isExpired)
        case _ => None
    }

    def refreshToken(withRefreshToken: UUID, withGrantType: String): Unit = {
      val canRefresh = token match {
        case Some(token) => token.canRefresh(withRefreshToken, withGrantType)
        case _ => false
      }

      if (canRefresh) {
        token = Some(new Token(
          accessToken = java.util.UUID.randomUUID,
          refreshToken = java.util.UUID.randomUUID,
          generatedIn = DateTime.now(),
          tokenType = "bearer"
        ))
      }
    }

    def revoke(): Unit = {
      token = None
    }
}
