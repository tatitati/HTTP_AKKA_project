package learning.serialize

import com.github.nscala_time.time.Imports._
import org.json4s._
import org.json4s.native.Serialization.write
import org.scalatest.FunSuite
import FieldSerializer._

class CustomSerializerSpec extends FunSuite {

  class GivenClass(val firstName: String, val age: Int)
  class GivenClassWithDate(val firstName: String, val date: DateTime)

  test("I can use a custom serializer that only rename fields when parsing or serializing") {
    val customSerializer = FieldSerializer[GivenClass](
      renameTo("firstName", "this_is_the_name"),
      renameFrom("from_first_name", "firstName"))

    implicit val formats = DefaultFormats + customSerializer

    val instance = new GivenClass("francisco", 34)
    val jsonString = write(instance)

    assert(jsonString === """{"this_is_the_name":"francisco","age":34}""")
  }

  test("DateTimes are not serialized properly") {
    implicit val formats = DefaultFormats

    val instance = new GivenClassWithDate("francisco", DateTime.now())
    val jsonString = write(instance)

    assert(jsonString === """{"firstName":"francisco","date":{}}""")
  }
}
