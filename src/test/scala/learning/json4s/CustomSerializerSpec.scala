//package learning.serialize
//
//import com.github.nscala_time.time.Imports._
//import net.liftweb.json.JsonAST.JString
//import net.liftweb.json.{JField, JObject, _}
//import net.liftweb.json.Serialization.write
//import org.scalatest.FunSuite
//
//
//class GivenClass(val name: String, val date: DateTime)
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
//class CustomSerializerSpec extends FunSuite {
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
//}
