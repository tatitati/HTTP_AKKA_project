package app.infrastructure.serializer

import app.domain.Scope
import app.domain.ownerstore.OwnerProfile
import app.domain.thirdstore.ThirdProfile
import app.domain.thirdstore.resourcestore.{Code, ResourceByCode}
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
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

  def toDomain(serialized: String): ResourceByCode = {

    val jodaDateReads = Reads[DateTime](js =>
      js.validate[String].map[DateTime](dtString =>
        DateTime.parse(dtString, DateTimeFormat.forPattern( "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
        ))
      )
    )



    val parsed = Json.parse(serialized)

    val thirdProfile = new ThirdProfile(
      name = (parsed \ "thirdProfile" \ "name").as[String],
      clientid = (parsed \ "thirdProfile" \ "clientid").as[String],
      clientsecret = (parsed \ "thirdProfile" \ "clientsecret").as[String],
      callback = (parsed \ "thirdProfile" \ "callback").as[String],
      homepage = (parsed \ "thirdProfile" \ "homepage").as[String],
      description = (parsed \ "thirdProfile" \ "description").as[String]
    )

    val ownerProfile = new OwnerProfile(
      firstname = (parsed \ "ownerProfile" \ "firstname").as[String],
      surname = (parsed \ "ownerProfile" \ "surname").as[String],
      email = (parsed \ "ownerProfile" \ "email").as[String],
      emailconfirmed = (parsed \ "ownerProfile" \ "emailconfirmed").as[Boolean],
      datebirth = (parsed \ "ownerProfile" \ "datebirth").as[DateTime](jodaDateReads),
    )

    val scope = Scope(
      firstname = (parsed \ "scope" \ "firstname").as[Boolean],
      surname = (parsed \ "scope" \ "surname").as[Boolean],
      email = (parsed \ "scope" \ "email").as[Boolean],
    )

    val code = Code(
      code = (parsed \ "code" \ "code").as[String],
      expiresIn = (parsed \ "code" \ "expiresIn").as[Int],
      generatedIn = (parsed \ "code" \ "generatedIn").as[DateTime](jodaDateReads),
      state = (parsed \ "code" \ "state").as[String],
    )

    new ResourceByCode(
      thirdProfile = thirdProfile,
      ownerProfile = ownerProfile,
      scope = scope,
      code = code
    )
  }
}
