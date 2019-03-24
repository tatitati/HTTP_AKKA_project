package test.app.domain.model.owner

import java.util.UUID
import app.domain.model.user.UserId
import builders.BuildUuid

object BuildUserId {

  def any(withValue: UUID = BuildUuid.any()): UserId = {
    UserId(withValue)
  }
}
