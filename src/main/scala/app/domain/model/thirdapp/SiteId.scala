package app.domain.model.thirdapp

import java.util.UUID

case class SiteId(value: UUID) {
  override def toString(): String = {
    value.toString
  }
}
