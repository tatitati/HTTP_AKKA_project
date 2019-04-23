package app.infrastructure.persistence.third

case class ThirdPersistentModel(
   surrogateId: Option[Long] = None,
   id: String,
   name: String,
   callback: String,
   homepage: String,
   description: String
)
