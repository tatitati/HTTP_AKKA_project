package test.app.infrastructure.persistence.thirdapp

import app.infrastructure.persistence.Exec
import app.infrastructure.persistence.thirdapp._
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import slick.jdbc.MySQLProfile.api._
import slick.lifted.TableQuery

class ThirdappRepositorySpec extends FunSuite with BeforeAndAfterEach with Exec {
  val thirdappSchema = TableQuery[ThirdappSchema]
  implicit val db = Database.forConfig("mydb")

  test("I can insert a new third") {
    ThirdappRepository.save(
      BuildThirdappPersistentModel.anyNoPersisted(
        withName = "my row"
      )
    )

    val rows = exec(thirdappSchema.result)

    assert(rows.size === 1)
    assert(rows.isInstanceOf[Vector[_]])
    assert(rows.head.isInstanceOf[ThirdappPersistentModel])
    assert(rows.head.name === "my row")
    assert(rows.head.surrogateId.isInstanceOf[Some[_]])
  }

//  test("I understand how to filter") {
//    val query = thirdappSchema.filter(_.name === "something").result.statements.mkString
//    assert(query === "select `id`, `thirdid`, `name`, `callback`, `homepage`, `description` from `third` where `name` = 'something'")
//  }
//
//  test("Read return a third aggregate") {
//    ThirdRepository.save(
//      BuildThirdPersistentModel.anyNoPersisted(withName = "my row")
//    )
//
//    val third = ThirdRepository.read(byname = "my row")
//
//    assert(third.isInstanceOf[Third])
//    assert(third.getProfile.name === "my row")
//    assert(third.getSurrogateId().isInstanceOf[Some[_]])
//  }

  override def beforeEach() {
    exec(thirdappSchema.schema.dropIfExists)
    exec(thirdappSchema.schema.create)
  }
}
