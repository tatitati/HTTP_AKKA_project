package app.domain.model.app

import java.util.UUID

case class AppId(value: UUID) {
  override def toString(): String = {
    value.toString
  }
}
