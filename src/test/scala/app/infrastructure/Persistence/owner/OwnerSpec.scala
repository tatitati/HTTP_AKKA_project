package app.infrastructure.Persistence.owner

import app.infrastructure.Persistence.Exec
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import slick.jdbc.MySQLProfile.api._
import slick.jdbc.meta.MTable
import slick.lifted.TableQuery
import test.app.infrastructure.Persistence.owner.OwnerProfileSchema

class OwnerSpec extends FunSuite with BeforeAndAfterEach with Exec {
  val ownerSchema = TableQuery[OwnerProfileSchema]
  implicit val db = Database.forConfig("mydb")

  test("third table exists") {
    val tables = exec(MTable.getTables).toList
    assert(tables.exists(_.name.name == "third") === true)
  }

  test("database forconfig type is:") {
    assert(db.isInstanceOf[Database])
  }

  override def beforeEach() {
    exec(ownerSchema.schema.dropIfExists)
    exec(ownerSchema.schema.create)
  }
}
