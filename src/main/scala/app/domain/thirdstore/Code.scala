package app.domain.thirdstore

import com.github.nscala_time.time.Imports._

case class Code(
               private val code: String,
               private val expiresIn: Int = 60,
               private val generatedIn: DateTime,
               private val state: String
    ) {
}
