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

  def toDomain(persisted: ScopePersistedModel): Scope = {
    var scope = Scope(
      firstname = persisted.firstname,
      surname = persisted.surname,
      email = persisted.email
    )


    persisted.id match {
      case None => throw new IllegalArgumentException("A persisted Scope is expected to have an id in order to be mapped to domain")
      case Some(value) if value.isInstanceOf[Long] => scope.setSurrogateId(persisted.id)
    }

    scope
  }
}
