package test.app.infrastructure.repository.third

import app.infrastructure.repository.Exec
import app.infrastructure.repository.third.{ThirdPersistedModel, ThirdSchema}
import org.scalatest.{BeforeAndAfterAll, FunSuite}
import slick.jdbc.MySQLProfile.api._
import slick.lifted.TableQuery
import test.builders.infrastructure.BuildThirdPersistedModel

class ThirdSchemaSpec extends FunSuite with BeforeAndAfterAll with Exec {
  val thirdSchema = TableQuery[ThirdSchema]
  implicit val db = Database.forConfig("mydb")

  test("I can create thirdSchema") {
    assert(
      thirdSchema.schema.create.statements ===
        Vector("create table `third` (`id` BIGINT AUTO_INCREMENT PRIMARY KEY,`name` TEXT NOT NULL,`callback` TEXT NOT NULL,`homepage` TEXT NOT NULL,`description` TEXT NOT NULL,`client_id` TEXT NOT NULL,`client_secret` TEXT NOT NULL)")
    )
  }

  test("Statements represent the SQL query CREATE TABLE") {
    exec(thirdSchema.schema.create)
  }

  test("I can insert some data") {
    val rows1 = exec(thirdSchema.result)
    assert(rows1.size === 0)

    exec(thirdSchema += BuildThirdPersistedModel.any(
      withName = "my row"
    ))

    val rows2 = exec(thirdSchema.result)
    assert(rows2.size === 1)
    assert(rows2.isInstanceOf[Vector[_]])
    assert(rows2.head.isInstanceOf[ThirdPersistedModel])
  }

  test("On select I get a vector of ThirdPersistedModel elements") {

    exec(thirdSchema += BuildThirdPersistedModel.any(
      withName = "my row"
    ))

    val rows = exec(thirdSchema.result)
    assert(rows.isInstanceOf[Vector[_]])
    assert(rows.head.isInstanceOf[ThirdPersistedModel])
  }

  test("On insert the id is created automatically") {

    exec(thirdSchema += BuildThirdPersistedModel.any(
      withId = None,
      withName = "my row"
    ))

    val rows = exec(thirdSchema.result)
    val first = rows.head
    assert(first.isInstanceOf[ThirdPersistedModel])
    assert(first.id.isInstanceOf[Some[_]])
  }

  override def beforeAll() {
    exec(thirdSchema.schema.dropIfExists)
  }

  override def afterAll() {
    exec(thirdSchema.schema.drop)
  }
}
