package app.domain.thirdstore

import java.util.UUID

import app.domain.{Scope, Token}
import app.domain.ownerstore.OwnerProfile
import com.github.nscala_time.time.Imports.DateTime
import scala.util.{Success, Try}

class Resource(
                private val ownerProfile: OwnerProfile,
                private val scope: Scope,
                var token: Option[Token]
    ){

    def firstname(): Option[String] = // should this throw an exception??, it will be more clear.
      scope.firstname match {
        case true if !isExpired.getOrElse(false) => Option(ownerProfile.firstname)
        case _ => None
    }

    def surname(): Option[String] = scope.surname match {
        case true if !isExpired.getOrElse(false) => Option(ownerProfile.surname)
        case _ => None
    }

    def email(): Option[String] = scope.email match {
        case true if !isExpired.getOrElse(false) => Option(ownerProfile.email)
        case _ => None
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
