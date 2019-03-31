package test.app.domain.code

import app.domain.code.Code
import app.domain.model.Scope
import app.domain.model.site.SiteId
import app.domain.model.code.CodeId
import app.domain.model.user.UserId
import test.app.domain.model.BuildScope
import test.app.domain.model.code.BuildCodeId
import test.app.domain.model.site.BuildSiteId
import test.app.domain.model.user.BuildUserId
import test.builders.Faker

object BuildCode {

  def any(
           withId: CodeId = BuildCodeId.any(),
           withUserId: UserId = BuildUserId.any(),
           withSiteId: SiteId = BuildSiteId.any(),
           withState: String = Faker.text(),
           withScope: Scope = BuildScope.any(),
         ): Code  = {

    Code(
      withId,
      withUserId,
      withSiteId,
      withState,
      withScope
    )
  }

  def specific(): Code = {
    any(
      withId = BuildCodeId.specific1(),
      withUserId = BuildUserId.specific1(),
      withSiteId = BuildSiteId.specific1(),
      withState = "any state",
      withScope = BuildScope.onlyEmailAndFirstname()
    )
  }
}
