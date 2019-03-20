package test.app.infrastructure.Persistence.resource

import app.infrastructure.Persistence.Exec
import app.infrastructure.Persistence.resource.ScopeSchema
import builders.infrastructure.BuildScopePersistedModel
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import slick.jdbc.MySQLProfile.api._
import slick.jdbc.meta.MTable
import slick.lifted.TableQuery

class ScopeSchemaSpec extends FunSuite with BeforeAndAfterEach with Exec {
  val scopeSchema = TableQuery[ScopeSchema]
  implicit val db = Database.forConfig("mydb")

  test("database forconfig type is:") {
    assert(db.isInstanceOf[Database])
  }

  test("scope table exists") {
    val tables = exec(MTable.getTables).toList
    assert(tables.exists(_.name.name == "scope") === true)
  }

  test("Can save one scope persistent model") {
    val persistentModel = BuildScopePersistedModel.anyWithOnlyEmail(withId = None)
    exec(scopeSchema += persistentModel)
  }

  override def beforeEach() {
    exec(scopeSchema.schema.dropIfExists)
    exec(scopeSchema.schema.create)
  }
}
