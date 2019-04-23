//package app.infrastructure.persistence.thirdapp
//
//import slick.jdbc.MySQLProfile.api._
//import slick.lifted.Tag
//
//class ThirdappSchema(tag: Tag) extends Table[ThirdappPersistentModel](tag, "thirdapp") {
//  def surrogateId = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
//  def thirdId = column[String]("thirdid")
//  def name = column[String]("name", O.SqlType("VARCHAR(255)"))
//  def callback = column[String]("callback")
//  def homepage = column[String]("homepage", O.SqlType("VARCHAR(255)"))
//  def description = column[String]("description")
//
//  def * = (
//    surrogateId,
//    thirdId,
//    name,
//    callback,
//    homepage,
//    description
//  ).mapTo[ThirdappPersistentModel]
//
//  def refreshAccessIndex = index("third____name_and_homepage____idx", (name, homepage), unique=true)
//}
