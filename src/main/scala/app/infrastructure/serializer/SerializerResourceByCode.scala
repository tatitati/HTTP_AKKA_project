package app.infrastructure.serializer

import app.domain.thirdstore.resourcestore.ResourceByCode
import org.json4s._
import org.json4s.jackson.JsonMethods.{compact, render}
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

object SerializerResourceByCode {

  def toJson(resourceByCode: ResourceByCode): String = {
    val givenMap =
      ("thirdProfile" ->
          ("name" -> resourceByCode.thirdProfile.name) ~
          ("clientid" -> resourceByCode.thirdProfile.clientid) ~
          ("clientsecret" -> resourceByCode.thirdProfile.clientsecret) ~
          ("callback" -> resourceByCode.thirdProfile.callback) ~
          ("homepage" -> resourceByCode.thirdProfile.homepage) ~
          ("description" -> resourceByCode.thirdProfile.description)) ~
        ("ownerProfile" ->
          ("firstname" -> resourceByCode.ownerProfile.firstname) ~
          ("surname" -> resourceByCode.ownerProfile.surname) ~
          ("email" -> resourceByCode.ownerProfile.email) ~
          ("emailconfirmed" -> resourceByCode.ownerProfile.emailconfirmed) ~
          ("datebirth" -> resourceByCode.ownerProfile.datebirth.toString())) ~
        ("scope" ->
          ("firstname" -> resourceByCode.scope.firstname) ~
          ("surname" -> resourceByCode.scope.surname) ~
          ("email" -> resourceByCode.scope.email)) ~
        ("code" ->
          ("code" -> resourceByCode.code.code) ~
          ("expiresIn" -> resourceByCode.code.expiresIn) ~
          ("generatedIn" -> resourceByCode.code.generatedIn.toString()) ~
          ("state" -> resourceByCode.code.state))



    compact(render(givenMap))
  }
}
