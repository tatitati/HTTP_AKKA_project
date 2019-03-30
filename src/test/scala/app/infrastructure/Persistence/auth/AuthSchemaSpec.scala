package test.app.infrastructure.Persistence.auth

import app.infrastructure.Persistence.Exec
import app.infrastructure.Persistence.auth.AuthSchema
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import slick.jdbc.MySQLProfile.api._
import slick.jdbc.meta.MTable
import slick.lifted.TableQuery

class AuthSchemaSpec extends FunSuite with BeforeAndAfterEach with Exec {
  val authSchema = TableQuery[AuthSchema]
  implicit val db = Database.forConfig("mydb")

  test("database forconfig type is:") {
    assert(db.isInstanceOf[Database])
  }

  test("auth table exists") {
    val tables = exec(MTable.getTables).toList
    assert(tables.exists(_.name.name == "auth") === true)
  }

  test("Can save one owner profile persistence model") {
    val persistentModel = BuildAuthPersistentModel.any()
    exec(authSchema += persistentModel)
  }

  override def beforeEach() {
    exec(authSchema.schema.dropIfExists)
    exec(authSchema.schema.create)
  }
}

