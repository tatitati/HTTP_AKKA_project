package app.domain.thirdstore

import com.github.nscala_time.time.Imports._

class Code(
               private val code: String,
               private val expiresIn: Int,
               private val generatedIn: DateTime
               ) {

    def isExpired(): Boolean = {
      val expireInDate = generatedIn + expiresIn.seconds
      val now = DateTime.now()
      expireInDate < now
    }
}
