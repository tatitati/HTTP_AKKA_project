package test.app.domain.model.thirdapp

import java.util.UUID
import app.domain.model.thirdapp.SiteId
import test.builders.BuildUuid

object BuildSiteId {
  def any(withValue: UUID = BuildUuid.any()): SiteId = {
    SiteId(withValue)
  }

  def specific1(): SiteId = {
    any(withValue = BuildUuid.uuidOne())
  }

  def specific2(): SiteId = {
    any(withValue = BuildUuid.uuidTwo())
  }
}
