package test.app.domain.model.code

import java.util.UUID

import app.domain.model.code.CodeId
import test.builders.BuildUuid

object BuildCodeId {

  def any(withValue: UUID = BuildUuid.any()): CodeId = {
    CodeId(withValue)
  }

  def any1(): CodeId = {
    any(withValue = BuildUuid.uuidOne())
  }

  def any2(): CodeId = {
    any(withValue = BuildUuid.uuidTwo())
  }
}
