package builders.authorizes

import app.domain.Scope
import builders.AnyFrom

object BuildScope {

  def onlyEmailAndFirstname(): Scope = {
    new Scope(true, false, true)
  }

  def onlySurname(): Scope = {
    new Scope(false, true, false)
  }

  def any(): Scope = {
    new Scope(
      AnyFrom.boolean(),
      AnyFrom.boolean(),
      AnyFrom.boolean()
    )
  }
}
