package app.domain.code

import test.builders.Faker

object BuildScope {

  def onlyEmailAndFirstname(withSurrogateId: Option[Long] = None): Scope = {
    val scope = new Scope(true, false, true)

    if (withSurrogateId != None) {
      scope.setSurrogateId(withSurrogateId)
    }

    scope
  }

  def onlySurname(withSurrogateId: Option[Long] = None): Scope = {
    val scope = new Scope(false, true, false)

    if (withSurrogateId != None) {
      scope.setSurrogateId(withSurrogateId)
    }

    scope
  }

  def any(withSurrogateId: Option[Long] = None): Scope = {
    Faker(
      onlyEmailAndFirstname(withSurrogateId),
      onlySurname(withSurrogateId)
    )
  }
}
