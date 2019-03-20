package app.infrastructure.Persistence.resource

case class ScopePersistedModel(
  id: Option[Long] = None,
  firstname: Boolean,
  surname: Boolean,
  email: Boolean
)
