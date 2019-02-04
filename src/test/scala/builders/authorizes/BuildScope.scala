package builders.authorizes

import app.domain.ownerstore.auth.Scope

object BuildScope {

  def onlyEmailAndFirstname(): Scope = {
    new Scope(true, false, true)
  }

  def onlySurname(): Scope = {
    new Scope(false, true, false)
  }
}
