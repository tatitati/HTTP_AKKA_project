package app.infrastructure.Persistence.owner

import app.infrastructure.Persistence.Exec
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import slick.jdbc.MySQLProfile.api._
import slick.jdbc.meta.MTable
import slick.lifted.TableQuery
import test.app.infrastructure.Persistence.owner.OwnerProfileSchema
import test.builders.infrastructure.BuildOwnerProfilePersistedModel

class OwnerProfileSchemaSpec extends FunSuite with BeforeAndAfterEach with Exec {
  val ownerSchema = TableQuery[OwnerProfileSchema]
  implicit val db = Database.forConfig("mydb")

  test("database forconfig type is:") {
    assert(db.isInstanceOf[Database])
  }

  test("owner_profile table exists") {
    val tables = exec(MTable.getTables).toList
    assert(tables.exists(_.name.name == "owner_profile") === true)
  }

  test("Can save one owner profile persistence model") {
    val persistentModel = BuildOwnerProfilePersistedModel.anyNoPersisted()
    exec(ownerSchema += persistentModel)
  }


  override def beforeEach() {
    exec(ownerSchema.schema.dropIfExists)
    exec(ownerSchema.schema.create)
  }
}
