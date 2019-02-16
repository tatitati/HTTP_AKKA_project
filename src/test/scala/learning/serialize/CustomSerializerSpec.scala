package learning.serialize

import com.github.nscala_time.time.Imports.DateTime
import net.liftweb.json.JsonAST.JString
import net.liftweb.json._
import net.liftweb.json.Serialization.write
import org.scalatest.FunSuite
import test.builders.BuildResourceByCode

class CustomSerializerSpec extends FunSuite {
  class SerializerDateTime extends Serializer[DateTime] {
    private val Class = classOf[DateTime]

    def deserialize(implicit format: Formats) = {
      case (TypeInfo(Class, _), json) => json match {
        case JString(x)  => DateTime.parse(x)
        case x => throw new MappingException("Can't convert " + x + " to DateTime")
      }
    }

    def serialize(implicit format: Formats) = {
      case p: DateTime => JString(p.toString("===YYYY==="))
    }
  }

  test("I can convert to json an object using lift-json") {
    implicit val formats =  Serialization.formats(NoTypeHints) + new SerializerDateTime

    class GivenClass(val name: String, val date: DateTime)

    val jsonString = write(new GivenClass("francisco", DateTime.now()))

    assert(jsonString === """{"name":"francisco","date":"===2019==="}""")
  }
}
