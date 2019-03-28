package app.infrastructure.Persistence.auth

import slick.jdbc.MySQLProfile.api._
import com.github.nscala_time.time.Imports.DateTime
import slick.lifted.Tag

class AuthSchema(tag: Tag) extends Table[AuthPersistentModel](tag, "auth") {

  import app.infrastructure.Persistence.CustomDateTimeToTimestamp._

  def surrogateid = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)

  def id = column[String]("authid")
  def thirdid = column[String]("thirdid")
  def userid = column[String]("userid")

  def scopefirstname = column[Boolean]("scope_firstname")
  def scopesurname = column[Boolean]("scope_surname")
  def scopeemail = column[Boolean]("scope_email")

  def tokentype = column[String]("token_type")
  def tokenaccess = column[String]("token_access")
  def tokenrefresh = column[String]("token_refresh")
  def tokenexpiresin = column[Int]("token_expiresin")
  def tokengeneratedin = column[DateTime]("generated_in", O.SqlType("DATETIME"))

  def * = (
      surrogateid,
      id,
      thirdid,
      userid,
      scopefirstname,
      scopesurname,
      scopeemail,
      tokentype,
      tokenaccess,
      tokenrefresh,
      tokenexpiresin,
      tokengeneratedin,
    ).mapTo[AuthPersistentModel]
}