package app.domain.thirdstore

import app.domain.ownerstore.Profile
import app.domain.ownerstore.authorizations.Scope

class Resource(
                private val profile: Profile,
                private val scopes: Scope,
                private var token: Option[Token]
          ){

    def firstname(): Option[String] = scopes.firstname match {
        case true => Option(profile.firstname)
        case _ => None
    }

    def surname(): Option[String] = scopes.surname match {
        case true => Option(profile.surname)
        case _ => None
    }

    def email(): Option[String] = scopes.email match {
        case true => Option(profile.email)
        case _ => None
    }

    def isTokenExpired(): Option[Boolean] = token match {
        case Some(token) => Option(token.isExpired)
        case _ => None

    }

    def refreshToken(): Unit = {
         if(isTokenExpired() == Some(true)) {
           token match {
             case Some(token) => token.refresh(token.refreshToken, "refresh_token")
           }
         }
    }

    def gettoken(): Option[Token] = {
      token
    }

    def revokeToken(): Unit = {
      token = None
    }

}
