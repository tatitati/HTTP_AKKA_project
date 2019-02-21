package app.infrastructure.serializer

import app.domain.thirdstore.ThirdProfile
import app.domain.thirdstore.resourcestore.ResourceByCode
import org.joda.time.DateTime
import play.api.libs.json.{Json, _}

object SerializerResourceByCode {

  def toJson(resourceByCode: ResourceByCode): String = {

    val memento = resourceByCode.exportMemento()
    val givenMap = Json.obj(
  "thirdProfile" -> Json.obj(
            "name" -> memento.thirdProfileName,
            "clientid" -> memento.thirdClientId,
            "clientsecret" -> memento.thirdClientSecret,
            "callback" -> memento.thirdCallback,
            "homepage" -> memento.thirdHomepage,
            "description" -> memento.thirdDescription
        ),
        "ownerProfile" -> Json.obj(
          "firstname" -> memento.ownerFirstname,
          "surname" -> memento.ownerSurname,
          "email" -> memento.ownerEmail,
          "emailconfirmed" -> memento.ownerEmailconfirmed,
          "datebirth" -> memento.ownerDatebirth.toString()
        ),
        "scope" -> Json.obj(
          "firstname" -> memento.scopeFirstname,
          "surname" -> memento.scopeSurname,
          "email" -> memento.scopeEmail
        ),
        "code" -> Json.obj(
          "code" -> memento.code,
          "expiresIn" -> memento.codeExpiresin,
          "generatedIn" -> memento.codeGeneratedIn.toString(),
          "state" -> memento.codeState
        )
    )

    Json.stringify(givenMap)
  }
//
//  def toDomain(serialized: String): ResourceByCode = {
//    implicit val formats = DefaultFormats
//
//    val parsed = parse(serialized)
//
//    val thirdProfile = new ThirdProfile(
//      name = (parsed \ "thirdProfile" \ "name").extract[String],
//      clientid = (parsed \ "thirdProfile" \ "clientid").extract[String],
//      clientsecret = (parsed \ "thirdProfile" \ "clientsecret").extract[String],
//      callback = (parsed \ "thirdProfile" \ "callback").extract[String],
//      homepage = (parsed \ "thirdProfile" \ "homepage").extract[String],
//      description = (parsed \ "thirdProfile" \ "description").extract[String]
//    )
//  }
}
