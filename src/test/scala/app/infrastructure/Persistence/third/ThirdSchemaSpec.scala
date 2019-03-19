package test.app.infrastructure.Persistence.third

import app.infrastructure.Persistence.Exec
import app.infrastructure.Persistence.third.ThirdSchema
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import slick.jdbc.MySQLProfile.api._
import slick.jdbc.meta.MTable
import slick.lifted.TableQuery
import test.app.infrastructure.Persistence.owner.OwnerProfileSchema

class ThirdSchemaSpec extends FunSuite with BeforeAndAfterEach with Exec {
  val ownerSchema = TableQuery[ThirdSchema]
  implicit val db = Database.forConfig("mydb")

  test("database forconfig type is:") {
    assert(db.isInstanceOf[Database])
  }

  test("third table exists") {
    val tables = exec(MTable.getTables).toList
    assert(tables.exists(_.name.name == "third") === true)
  }




  override def beforeEach() {
    exec(ownerSchema.schema.dropIfExists)
    exec(ownerSchema.schema.create)
  }
}

