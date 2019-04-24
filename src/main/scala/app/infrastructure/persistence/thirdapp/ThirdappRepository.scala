package app.infrastructure.persistence.thirdapp

import app.domain.model.thirdapp.Thirdapp
import slick.jdbc.MySQLProfile.api._
import slick.lifted.TableQuery
import app.infrastructure.persistence.Exec

object ThirdappRepository extends Exec {

  val thirdappSchema = TableQuery[ThirdappSchema]
  implicit val db = Database.forConfig("mydb")

  def save(persistentModel: ThirdappPersistentModel): Unit = {
    exec(thirdappSchema += persistentModel)
  }

  def read(byname: String): Thirdapp = {
    val rows = exec(thirdappSchema.filter(_.name === byname).result)

    val thirdPersisted = rows.head

    ThirdappMapper.toDomain(thirdPersisted)
  }
}
