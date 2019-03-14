package app.infrastructure.Persistence.third

import app.domain.third.Third
import slick.jdbc.MySQLProfile.api._
import slick.lifted.TableQuery
import app.infrastructure.Persistence.Exec

object ThirdDao extends Exec {

  val thirdSchema = TableQuery[ThirdSchema]
  implicit val db = Database.forConfig("mydb")

  def save(persistentModel: ThirdPersistedModel): Unit = {
    exec(thirdSchema += persistentModel)
  }

  def read(byname: String): Third = {
    val rows = exec(thirdSchema.filter(_.name === byname).result)

    val thirdPersisted = rows.head

    ThirdMapper.toDomain(thirdPersisted)
  }
}
