package learning.serialize

import com.github.nscala_time.time.Imports._
import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.JsonAST
import org.json4s.jackson.JsonMethods._
import org.scalatest.FunSuite
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import org.scalatest.FunSuite
import FieldSerializer._

//
//
class GivenClass(val firstName: String, val age: Int)
//
//class SerializerDateTime extends Serializer[DateTime] {
//  private val Class = classOf[DateTime]
//
//  def serialize(implicit format: Formats) = {
//    case variable: DateTime => JString(variable.toString("===YYYY==="))
//  }
//
//  def deserialize(implicit format: Formats) = {
//    case (TypeInfo(Class, _), json) => json match {
//      case JField("date",JString(value)) =>
//            DateTime.parse(value, DateTimeFormat.forPattern("===YYYY==="))
//      case x => throw new MappingException("Can't convert " + x + " to DateTime")
//    }
//  }
//}
//
class CustomSerializerSpec extends FunSuite {

  test("I can use a custom serializer") {
    val customSerializer = FieldSerializer[GivenClass](
      renameTo("firstName", "this_is_the_name"),
      renameFrom("from_first_name", "firstName"))

    implicit val formats = DefaultFormats + customSerializer

    val instance = new GivenClass("francisco", 34)
    val jsonString = write(instance)

    assert(jsonString === """{"this_is_the_name":"francisco","age":34}""")
  }

//
//  implicit val formats =  Serialization.formats(NoTypeHints) + new SerializerDateTime
//
//  test("I can convert to json an object using lift-json") {
//    val jsonString = write(new GivenClass("francisco", DateTime.now()))
//
//    assert(jsonString === """{"name":"francisco","date":"===2019==="}""")
//  }
//
////  test("Can deserialize using the custom deserializer") {
////
////    val givenJson = """{"name":"francisco","date":"===2019==="}"""
////
////    val value = parse(givenJson)
////
////    assert(value === JObject(List(JField("name",JString("francisco")), JField("date",JString("===2019===")))))
////
////
////    println(value.extract)
////  }
}
