package builders.domain

import app.domain.resource.Scope
import test.builders.Faker

object BuildScope {

  def onlyEmailAndFirstname(): Scope = {
    new Scope(true, false, true)
  }

  def onlySurname(): Scope = {
    new Scope(false, true, false)
  }

  def any(): Scope = {
    Faker(onlyEmailAndFirstname(), onlySurname())
  }
}
