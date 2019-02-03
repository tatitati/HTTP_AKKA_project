package builders.authorizes

import app.domain.ownerstore.authorizations.Scope

object BuilderScope {

  def onlyEmailAndFirstname(): Scope = {
    new Scope(true, false, true)
  }

  def onlySurname(): Scope = {
    new Scope(false, true, false)
  }
}
