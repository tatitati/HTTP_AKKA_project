package app.infrastructure.Persistence.resourceByCode

case class ScopePersistedModel(
  id: Option[Long] = None,
  firstname: Boolean,
  surname: Boolean,
  email: Boolean
)
