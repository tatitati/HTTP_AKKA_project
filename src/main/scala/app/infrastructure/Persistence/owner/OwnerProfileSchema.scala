package test.app.infrastructure.Persistence.owner

import app.infrastructure.Persistence.owner.OwnerProfilePersistModel
import slick.jdbc.MySQLProfile.api._
import slick.lifted.Tag

class OwnerProfileSchema(tag: Tag) extends Table[OwnerProfilePersistModel](tag, "third") {
  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def callback = column[String]("callback")
  def homepage = column[String]("homepage")
  def description = column[String]("description")
  def clientId = column[String]("client_id")
  def clientSecret = column[String]("client_secret")

  def * = (
    id,
    name,
    callback,
    homepage,
    description,
    clientId,
    clientSecret
  ).mapTo[OwnerProfilePersistModel]
}
