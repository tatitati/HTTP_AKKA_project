package test.app.infrastructure.Persistence.code

import java.util.UUID

import app.domain.code.Code
import app.domain.model.Scope
import app.domain.model.code.CodeId
import app.domain.model.third.ThirdId
import app.domain.model.user.UserId
import play.api.libs.json.Json

object CodeSerializer {

  def toJson(code: Code): String = {

    val givenMap = Json.obj(
        "id" -> code.codeId.toString,
        "user_id" -> code.userId.toString,
        "third_id" -> code.thirdId.toString,
        "state" -> code.state,
        "scope" -> Json.obj(
          "firstname" -> code.scope.firstname,
          "surname" -> code.scope.surname,
          "email" -> code.scope.email
        ),
    )

    Json.stringify(givenMap)
  }

  def toDomain(serialized: String): Code = {

    val parsed = Json.parse(serialized)

    val id = (parsed \ "id").as[String]
    val userid = (parsed \ "user_id").as[String]
    val thirdid = (parsed \ "third_id").as[String]
    val scope = Scope(
      firstname = (parsed \ "scope" \ "firstname").as[Boolean],
      surname = (parsed \ "scope" \ "surname").as[Boolean],
      email = (parsed \ "scope" \ "email").as[Boolean],
    )

    new Code(
      codeId = CodeId(UUID.fromString(id)),
      userId = UserId(userid),
      thirdId = ThirdId(UUID.fromString(thirdid)),
      state = (parsed \ "state").as[String],
      scope = scope
    )
  }
}
