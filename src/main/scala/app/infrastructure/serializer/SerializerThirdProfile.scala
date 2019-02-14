package app.infrastructure.serializer

import app.domain.thirdstore.ThirdProfile
import net.liftweb.json.{DefaultFormats, Serialization}
import scala.util.parsing.json.JSON

object SerializerThirdProfile {

  def toJson(thirdProfile: ThirdProfile): String = {
    val jsonMap = Map(
      "name" -> thirdProfile.name,
      "homepage" -> thirdProfile.homepage,
      "callback" -> thirdProfile.callback,
      "clientsecret" -> thirdProfile.clientsecret,
      "clientid" -> thirdProfile.clientid,
      "description" -> thirdProfile.description
    )

    Serialization.write(jsonMap)(DefaultFormats)
  }

  def fromJson(withJson: String) = {
    val value = JSON.parseFull(withJson)


  }
}
