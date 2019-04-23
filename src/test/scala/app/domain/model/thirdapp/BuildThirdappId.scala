package test.app.domain.model.thirdapp

import java.util.UUID
import app.domain.model.thirdapp.ThirdappId
import test.builders.BuildUuid

object BuildThirdappId {
  def any(withValue: UUID = BuildUuid.any()): ThirdappId = {
    ThirdappId(withValue)
  }

  def specific1(): ThirdappId = {
    any(withValue = BuildUuid.uuidOne())
  }

  def specific2(): ThirdappId = {
    any(withValue = BuildUuid.uuidTwo())
  }
}
