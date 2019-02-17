package app.infrastructure.serializer

import app.domain.thirdstore.resourcestore.ResourceByCode
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write

object SerializerResourceByCode {

  def toJson(resourceByCode: ResourceByCode): String = {

    implicit val format = Serialization.formats(NoTypeHints)
    write(resourceByCode)
  }
}
