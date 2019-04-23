package app.infrastructure.persistence.third

import app.domain.third.Third
import slick.jdbc.MySQLProfile.api._
import slick.lifted.TableQuery
import app.infrastructure.persistence.Exec

object ThirdRepository extends Exec {

  val thirdSchema = TableQuery[ThirdSchema]
  implicit val db = Database.forConfig("mydb")

  def save(persistentModel: ThirdPersistentModel): Unit = {
    exec(thirdSchema += persistentModel)
  }

  def read(byname: String): Third = {
    val rows = exec(thirdSchema.filter(_.name === byname).result)

    val thirdPersisted = rows.head

    ThirdMapper.toDomain(thirdPersisted)
  }
}
