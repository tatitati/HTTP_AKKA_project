package app.infrastructure.repository.third

import slick.jdbc.MySQLProfile.api._
import slick.lifted.Tag


class ThirdSchema(tag: Tag) extends Table[ThirdPersistedModel](tag, "third") {
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
  ).mapTo[ThirdPersistedModel]
}
