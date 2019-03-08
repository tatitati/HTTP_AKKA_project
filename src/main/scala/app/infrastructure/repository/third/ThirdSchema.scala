package app.infrastructure.repository.third

import slick.jdbc.MySQLProfile.api._
import slick.lifted.Tag


//class ThirdSchema(tag: Tag) extends Table[ThirdPersistedModel](tag, "thirdpersistentmodel") {
//  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
//  def name = column[String]("first_name")
//  def callback = column[String]("first_name")
//  def homepage = column[String]("first_name")
//  def description = column[String]("first_name")
//  def clientid = column[String]("first_name")
//  def clientsecret = column[String]("first_name")
//
//  def * = (id, name, callback, homepage, description, clientid, clientsecret).mapTo[ThirdPersistedModel]
//}
