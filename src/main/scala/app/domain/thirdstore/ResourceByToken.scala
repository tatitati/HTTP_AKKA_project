package app.domain.thirdstore

import java.util.UUID
import app.domain.{Scope, Token}
import app.domain.ownerstore.OwnerProfile
import com.github.nscala_time.time.Imports.DateTime

class ResourceByToken(
                private val thirdProfile: ThirdProfile,
                private val ownerProfile: OwnerProfile,
                private val scope: Scope,
                var token: Token
    ){

    @throws(classOf[IllegalAccessException])
    def firstname(): String = // make dynamic all these accessors
      scope.firstname match {
        case true if !isTokenExpired => ownerProfile.firstname
        case true if isTokenExpired => throw new IllegalAccessException("The scope allows to access this property. However your token is expired and need to be refreshed")
        case _ => throw new IllegalAccessException("The scope doesn't allow you to access to firstname")
    }

    @throws(classOf[IllegalAccessException])
    def surname(): String = {
        scope.surname match {
          case true if !isTokenExpired => ownerProfile.surname
          case true if isTokenExpired => throw new IllegalAccessException("The scope allows to access this property. However your token is expired and need to be refreshed")
          case _ => throw new IllegalAccessException("The scope doesn't allow you to access to surname")
        }
    }

    @throws(classOf[IllegalAccessException])
    def email(): String = scope.email match {
        case true if !isTokenExpired => ownerProfile.email
        case true if isTokenExpired => throw new IllegalAccessException("The scope allows to access this property. However your token is expired and need to be refreshed")
        case _ => throw new IllegalAccessException("The scope doesn't allow you to access to email")
    }

    def isTokenExpired(): Boolean =  {
        token.isExpired
    }

    def refreshToken(withRefreshToken: UUID, withGrantType: String): Unit = {
      if(!token.canRefreshWithParams(withRefreshToken, withGrantType)) {
        throw new IllegalAccessException("The parameters used to refresh the token are invalid.")
      }

      if (!token.isExpired) {
        throw new IllegalAccessException("The token must be expired in order to be refreshed")
      }

      token = new Token(
        accessToken = java.util.UUID.randomUUID,
        refreshToken = java.util.UUID.randomUUID,
        generatedIn = DateTime.now(),
        tokenType = "bearer"
      )
    }
}
