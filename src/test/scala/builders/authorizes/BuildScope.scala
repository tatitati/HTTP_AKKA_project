package builders.authorizes

import app.domain.Scope
import builders.Faker

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
