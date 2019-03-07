package app.domain.resource

import java.util.UUID
import app.domain.factories.FactoryToken
import app.domain.owner.OwnerProfile
import app.domain.third.ThirdProfile

case class ResourceByToken(
                private val thirdProfile: ThirdProfile,
                private val ownerProfile: OwnerProfile,
                private val scope: Scope,
                val token: Token
    ){

    @throws(classOf[IllegalAccessException])
    def firstname(): String =
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

    def refreshToken(withRefreshToken: UUID, withGrantType: String): ResourceByToken = {
      if(!token.canRefreshWithParams(withRefreshToken, withGrantType)) {
        throw new IllegalAccessException("The parameters used to refresh the token are invalid.")
      }

      if (!token.isExpired) {
        throw new IllegalAccessException("The token must be expired in order to be refreshed")
      }

      this.copy(token = FactoryToken.create())
    }
}
