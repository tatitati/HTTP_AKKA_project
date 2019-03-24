package test.app.domain.model.user

import app.domain.model.user.UserId
import scala.util.Random

object BuildUserId {

  def any(withValue: String = text()): UserId = {
    UserId(withValue)
  }

  private def text(length: Int = 10): String = {
    val value = for(i <- 1 to length) yield { Random.nextPrintableChar() }
    value.mkString
  }
}
