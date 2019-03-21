package builders.domain

import java.util.UUID

import app.domain.owner.Auth
import app.domain.resource.{Scope, Token}
import app.domain.third.Third

object BuildAuth {

  def any(
           withUUID: UUID = BuildUuid.any(),
           withThird: Third = BuildThird.any(),
           withScope: Scope = BuildScope.any(),
           withToken: Option[Token] = Some(BuildToken.any())
         ): Auth = {
    new Auth(withUUID, withThird, withScope, withToken)
  }
}
