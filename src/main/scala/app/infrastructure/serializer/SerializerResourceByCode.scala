package app.infrastructure.serializer

import app.domain.thirdstore.resourcestore.ResourceByCode
import org.json4s.jackson.JsonMethods.{compact, render}
import org.json4s.JsonDSL._

object SerializerResourceByCode {

  def toJson(resourceByCode: ResourceByCode): String = {

    val memento = resourceByCode.exportMemento()

    val givenMap =
      ("thirdProfile" ->
          ("name" -> memento.thirdProfileName) ~
          ("clientid" -> memento.thirdClientId) ~
          ("clientsecret" -> memento.thirdClientSecret) ~
          ("callback" -> memento.thirdCallback) ~
          ("homepage" -> memento.thirdHomepage) ~
          ("description" -> memento.thirdDescription)) ~
        ("ownerProfile" ->
          ("firstname" -> memento.ownerFirstname) ~
          ("surname" -> memento.ownerSurname) ~
          ("email" -> memento.ownerEmail) ~
          ("emailconfirmed" -> memento.ownerEmailconfirmed) ~
          ("datebirth" -> memento.ownerDatebirth.toString())) ~
        ("scope" ->
          ("firstname" -> memento.scopeFirstname) ~
          ("surname" -> memento.scopeSurname) ~
          ("email" -> memento.scopeEmail)) ~
        ("code" ->
          ("code" -> memento.code) ~
          ("expiresIn" -> memento.codeExpiresin) ~
          ("generatedIn" -> memento.codeGeneratedIn.toString()) ~
          ("state" -> memento.codeState))

    compact(render(givenMap))
  }
}
