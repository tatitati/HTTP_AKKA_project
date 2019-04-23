package app.infrastructure.persistence.thirdapp

case class ThirdappPersistentModel(
  thirdappId: String,
  thirdId: String,
  // credentials
  clientid: String,
  clientsecret: String,
  // profile
  name: String,
  domain: String,
  description: String
)