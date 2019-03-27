package test.app.domain.model.third

import java.util.UUID
import app.domain.model.third.ThirdId
import test.builders.BuildUuid

object BuildThirdId {

  def any(withValue: UUID = BuildUuid.any()): ThirdId = {
    ThirdId(withValue)
  }

  def any1(): ThirdId = {
    any(withValue = BuildUuid.uuidOne())
  }

  def any2(): ThirdId = {
    any(withValue = BuildUuid.uuidTwo())
  }
}