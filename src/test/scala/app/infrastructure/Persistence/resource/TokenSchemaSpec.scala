package test.app.infrastructure.Persistence.resource

import app.infrastructure.Persistence.Exec
import app.infrastructure.Persistence.resource.TokenSchema
import builders.infrastructure.BuildTokenPersistedModel
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import slick.jdbc.MySQLProfile.api._
import slick.jdbc.meta.MTable
import slick.lifted.TableQuery

class TokenSchemaSpec extends FunSuite with BeforeAndAfterEach with Exec {
  val tokenSchema = TableQuery[TokenSchema]
  implicit val db = Database.forConfig("mydb")

  test("database forconfig type is:") {
    assert(db.isInstanceOf[Database])
  }

  test("scope table exists") {
    val tables = exec(MTable.getTables).toList
    assert(tables.exists(_.name.name == "token") === true)
  }



  test("Can save one scope persistent model") {
    val persistentModel = BuildTokenPersistedModel.any()
    val numRowsInserted = exec(tokenSchema += persistentModel)

    assert(numRowsInserted === 1)
  }

  override def beforeEach() {
    exec(tokenSchema.schema.dropIfExists)
    exec(tokenSchema.schema.create)
  }
}
