package app.domain.thirdstore

import com.github.nscala_time.time.Imports._

case class Code(
               code: String,
               expiresIn: Int,
               createdAt: DateTime
               ) {

}
