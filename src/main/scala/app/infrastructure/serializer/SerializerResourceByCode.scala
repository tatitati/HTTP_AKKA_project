//package app.infrastructure.serializer
//
//import app.domain.thirdstore.resourcestore.ResourceByCode
//import net.liftweb.json.{DefaultFormats, NoTypeHints, Serialization}
//import net.liftweb.json.Serialization.write
//
//object SerializerResourceByCode {
//
//  def toJson(resourceByCode: ResourceByCode): String = {
//
//    implicit val format = Serialization.formats(NoTypeHints)
//    write(resourceByCode)
//  }
//}
