package app.domain.auth

import com.github.nscala_time.time.Imports.DateTime

case class Code(
               val code: String,
               val expiresIn: Int = 60,
               val generatedIn: DateTime,
               val state: String
    ) {
}
