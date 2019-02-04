package app.domain.thirdstore

import app.domain.Profile
import app.domain.ownerstore.auth.Scope

class Resource(
                private val profile: Profile,
                private val scope: Scope,
                private var token: Option[Token]
    ){

    def firstname(): Option[String] = scope.firstname match {
        case true => Option(profile.firstname)
        case _ => None
    }

    def surname(): Option[String] = scope.surname match {
        case true => Option(profile.surname)
        case _ => None
    }

    def email(): Option[String] = scope.email match {
        case true => Option(profile.email)
        case _ => None
    }

    def gettoken(): Option[Token] = {
      token
    }

    def isTokenExpired(): Option[Boolean] = token match {
        case Some(token) => Option(token.isExpired)
        case _ => None
    }

    def refreshToken(): Unit = {
      val newtoken = token match {
        case Some(token) => token.refresh(token.refreshToken, "refresh_token")
        case _ => None
      }

      if(newtoken != None) {
        token = newtoken
      }
    }

    def revokeToken(): Unit = {
      token = None
    }

}
