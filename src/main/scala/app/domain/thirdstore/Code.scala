package app.domain.thirdstore

import com.github.nscala_time.time.Imports._

class Code(
               val code: String,
               private val expiresIn: Int,
               private val generatedIn: DateTime,
               private val state: String,
               private val clientId: String // dont need it
    ) {

    def isExpired(): Boolean = {
      val expireInDate = generatedIn + expiresIn.seconds
      val now = DateTime.now()
      expireInDate < now
    }
}
