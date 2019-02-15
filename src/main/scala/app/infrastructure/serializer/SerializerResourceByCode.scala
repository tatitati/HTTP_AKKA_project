package app.infrastructure.serializer

import app.domain.thirdstore.resourcestore.ResourceByCode
import net.liftweb.json.DefaultFormats
import net.liftweb.json.Serialization.write

object SerializerResourceByCode {

  def toJson(resourceByCode: ResourceByCode): String = {
//    implicit val formats = DefaultFormats
//    write(resourceByCode)
    ""
  }
}
