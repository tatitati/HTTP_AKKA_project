package app.infrastructure.Persistence.third

case class ThirdPersistedModel(
  id: Option[Long] = None,
  name: String,
  callback: String,
  homepage: String,
  description: String,
  clientId: String,
  clientSecret: String
)
