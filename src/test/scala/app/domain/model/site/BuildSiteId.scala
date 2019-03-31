package test.app.domain.model.site

import java.util.UUID
import app.domain.model.site.SiteId
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
