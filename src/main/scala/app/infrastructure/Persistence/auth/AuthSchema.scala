package app.infrastructure.Persistence.auth

import slick.jdbc.MySQLProfile.api._
import com.github.nscala_time.time.Imports.DateTime
import slick.lifted.Tag

class AuthSchema(tag: Tag) extends Table[AuthPersistentModel](tag, "auth") {

  import app.infrastructure.Persistence.CustomDateTimeToTimestamp._

  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def accessToken = column[String]("access_token")
  def tokenType = column[String]("token_type")
  def refreshToken = column[String]("refresh_token")
  def expiresIn = column[Int]("expires_in")
  def generatedIn = column[DateTime]("generated_in", O.SqlType("DATETIME"))

  def * = (
      id,
      accessToken,
      tokenType,
      refreshToken,
      expiresIn,
      generatedIn
    ).mapTo[AuthPersistentModel]
}