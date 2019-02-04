package builders.authorizes

import app.domain.ownerstore.authorization.Scope

object BuilderScope {

  def onlyEmailAndFirstname(): Scope = {
    new Scope(true, false, true)
  }

  def onlySurname(): Scope = {
    new Scope(false, true, false)
  }
}
