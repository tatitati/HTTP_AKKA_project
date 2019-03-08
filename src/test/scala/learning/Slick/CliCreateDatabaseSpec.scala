package test.learning.Slick


import app.infrastructure.repository.Exec
import org.scalatest.{BeforeAndAfterAll, FunSuite}
import slick.jdbc.MySQLProfile.api._
import slick.lifted.TableQuery
import test.learning.Slick.user.UserSchema

class CliCreateDatabaseSpec extends FunSuite with BeforeAndAfterAll with Exec {
  val userSchema = TableQuery[UserSchema]
  implicit val db = Database.forConfig("mydb")

  test("SQL files (migrations.sql) are found") {
    assert(userSchema.schema.create.statements === Vector("create table `user` (`first_name` TEXT NOT NULL,`last_name` TEXT NOT NULL,`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY)"))
  }

  test("Statements represent the SQL query CREATE TABLE") {
    exec(userSchema.schema.create)
  }

  override def beforeAll() {
    exec(userSchema.schema.dropIfExists)
  }

  override def afterAll() {
    exec(userSchema.schema.drop)
  }

}