package domain.test.model.code

import domain.model.code.Code
import domain.model.Scope
import domain.model.thirdapp.ThirdappId
import domain.model.code.CodeId
import domain.model.user.UserId
import domain.test.model.BuildScope
import domain.test.model.code.BuildCodeId
import domain.test.model.thirdapp.BuildThirdappId
import domain.test.model.user.BuildUserId
import domain.test.builders.Faker

object BuildCode {

  def any(
           withId: CodeId = BuildCodeId.any(),
           withUserId: UserId = BuildUserId.any(),
           withThirdappId: ThirdappId = BuildThirdappId.any(),
           withState: String = Faker.text(),
           withScope: Scope = BuildScope.any(),
         ): Code  = {

    Code(
      withId,
      withUserId,
      withThirdappId,
      withState,
      withScope
    )
  }

  def specific(): Code = {
    any(
      withId = BuildCodeId.specific1(),
      withUserId = BuildUserId.specific1(),
      withThirdappId = BuildThirdappId.specific1(),
      withState = "any state",
      withScope = BuildScope.onlyEmailAndFirstname()
    )
  }
}
