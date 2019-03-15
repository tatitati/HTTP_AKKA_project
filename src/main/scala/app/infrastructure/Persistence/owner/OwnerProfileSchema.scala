package test.app.infrastructure.Persistence.owner

import app.infrastructure.Persistence.owner.OwnerProfilePersistModel
import com.github.nscala_time.time.Imports.DateTime
import slick.jdbc.MySQLProfile.api._
import slick.lifted.Tag

class OwnerProfileSchema(tag: Tag) extends Table[OwnerProfilePersistModel](tag, "third") {

  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def firstname = column[String]("firstname")
  def surname = column[String]("surname")
  def email = column[String]("email")
  def emailconfirmed = column[Boolean]("email_confirmed")
  def datebirth = column[DateTime]("datebirth") // I need to create my own custom mapper

  def * = (
    id,
    firstname,
    surname,
    email,
    emailconfirmed,
    datebirth
  ).mapTo[OwnerProfilePersistModel]
}
