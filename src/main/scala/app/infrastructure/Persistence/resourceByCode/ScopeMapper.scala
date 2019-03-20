package app.infrastructure.Persistence.resourceByCode

import app.domain.resource.Scope

object ScopeMapper {

  def toPersistedModel(scope: Scope): ScopePersistedModel = {
    ScopePersistedModel(
      id = scope.getSurrogateId(),
      firstname = scope.firstname,
      surname = scope.surname,
      email = scope.email
    )
  }
}
