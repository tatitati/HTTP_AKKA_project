package test.app.domain.auth

import java.util.UUID
import app.domain.auth._
import app.domain.owner.OwnerEmail
import app.domain.third.ThirdUUID
import builders.domain._
import org.scalatest.FunSuite

class AuthSpec extends FunSuite {

  test("Have a UUID as identifier") {
    val givenAuth = BuildAuth.any()

    assert(givenAuth.uuid.isInstanceOf[UUID] == true)
  }

  test("User can know what permissions were granted to a third") {
    val givenAuth = BuildAuth.any(
      withScope = BuildScope.onlySurname()
    )

    assert(givenAuth.canReadFirstname === false, "=> Third should be able to access to firstname")
    assert(givenAuth.canReadSurname === true, "=> Third should be able to access to surname")
  }

  private def any(
          withUuid: AuthUUID,
          withThirdUUID: ThirdUUID,
          withOwnerEmail: OwnerEmail,
          withScope: Scope,
          withToken: Option[Token],
          withCode: Option[Code]
         ): Auth = {
    new Auth(withUuid, withThirdUUID, withOwnerEmail, withScope, withToken, withCode)
  }
}
