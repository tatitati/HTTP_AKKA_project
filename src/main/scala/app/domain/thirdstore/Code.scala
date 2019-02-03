package app.domain.thirdstore

import java.util.UUID

import org.joda.time.DateTime

class Code(val code: UUID, val generatedIn: DateTime) {

  val EXPIRES_IN = 30 // 30 secs


}
