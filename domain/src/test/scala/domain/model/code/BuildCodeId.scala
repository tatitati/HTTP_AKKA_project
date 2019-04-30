package domain.test.model.code

import java.util.UUID

import domain.model.code.CodeId
import domain.test.builders.BuildUuid

object BuildCodeId {

  def any(withValue: UUID = BuildUuid.any()): CodeId = {
    CodeId(withValue)
  }

  def specific1(): CodeId = {
    any(withValue = BuildUuid.uuidOne())
  }

  def specific2(): CodeId = {
    any(withValue = BuildUuid.uuidTwo())
  }
}
