package test.app.domain.auth

import java.util.UUID

import app.domain.third.{BuildThird, Third}
import builders.BuildUuid

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
