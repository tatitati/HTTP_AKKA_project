package test.app.domain.model.auth

import app.domain.model.auth.AuthScope
import test.builders.Faker

object BuildScope {

  def onlyEmailAndFirstname(withSurrogateId: Option[Long] = None): AuthScope = {
    new AuthScope(true, false, true)
  }

  def onlySurname(withSurrogateId: Option[Long] = None): AuthScope = {
    new AuthScope(false, true, false)
  }

  def any(withSurrogateId: Option[Long] = None): AuthScope = {
    Faker(
      onlyEmailAndFirstname(withSurrogateId),
      onlySurname(withSurrogateId)
    )
  }
}
