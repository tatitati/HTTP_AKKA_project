package app.domain.model.app

import java.util.UUID
import test.builders.BuildUuid

object BuildAppId {
  def any(withValue: UUID = BuildUuid.any()): AppId = {
    AppId(withValue)
  }

  def specific1(): AppId = {
    any(withValue = BuildUuid.uuidOne())
  }

  def specific2(): AppId = {
    any(withValue = BuildUuid.uuidTwo())
  }
}
