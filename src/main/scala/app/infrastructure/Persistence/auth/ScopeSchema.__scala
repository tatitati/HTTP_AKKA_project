package app.infrastructure.Persistence.resource

import slick.jdbc.MySQLProfile.api._
import slick.lifted.Tag

class ScopeSchema(tag: Tag) extends Table[ScopePersistedModel](tag, "scope") {

  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def firstname = column[Boolean]("firstname")
  def surname = column[Boolean]("surname")
  def email = column[Boolean]("email")

  def * = (
    id,
    firstname,
    surname,
    email
  ).mapTo[ScopePersistedModel]
}
