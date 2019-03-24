package test.app.domain.model.auth

import app.domain.model.auth.AuthScope
import test.builders.Faker

object BuildScope {

  def onlyEmailAndFirstname(withSurrogateId: Option[Long] = None): AuthScope = {
    val scope = new AuthScope(true, false, true)

    if (withSurrogateId != None) {
      scope.setSurrogateId(withSurrogateId)
    }

    scope
  }

  def onlySurname(withSurrogateId: Option[Long] = None): AuthScope = {
    val scope = new AuthScope(false, true, false)

    if (withSurrogateId != None) {
      scope.setSurrogateId(withSurrogateId)
    }

    scope
  }

  def any(withSurrogateId: Option[Long] = None): AuthScope = {
    Faker(
      onlyEmailAndFirstname(withSurrogateId),
      onlySurname(withSurrogateId)
    )
  }
}
