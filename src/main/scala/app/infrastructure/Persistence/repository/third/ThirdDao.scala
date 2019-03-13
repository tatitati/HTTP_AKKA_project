package app.infrastructure.Persistence.repository.third

import slick.jdbc.MySQLProfile.api._
import slick.lifted.TableQuery
import app.infrastructure.Persistence.Exec

object ThirdDao extends Exec {

  val thirdSchema = TableQuery[ThirdSchema]
  implicit val db = Database.forConfig("mydb")

  def save(persistentModel: ThirdPersistedModel) = {
    exec(thirdSchema += persistentModel)
  }

  def read(byname: String): Seq[ThirdPersistedModel] = {
    exec(thirdSchema.filter(_.name === byname).result)
  }
}
