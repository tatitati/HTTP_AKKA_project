package builders.domain

import app.domain.resource.Scope
import test.builders.Faker

object BuildScope {

  def onlyEmailAndFirstname(withSurrogateId: Option[Long] = None): Scope = {
    val scope = new Scope(true, false, true)
    
    if (withSurrogateId != None) {
      scope.setSurrogateId(withSurrogateId)
    }

    scope
  }

  def onlySurname(): Scope = {
    new Scope(false, true, false)
  }

  def any(): Scope = {
    Faker(onlyEmailAndFirstname(), onlySurname())
  }
}
