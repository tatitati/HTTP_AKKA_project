package test.app.domain.model.owner

import java.util.UUID
import app.domain.model.owner.OwnerId
import builders.BuildUuid

object BuildOwnerId {

  def any(withValue: UUID = BuildUuid.any()): OwnerId = {
    OwnerId(withValue)
  }
}
