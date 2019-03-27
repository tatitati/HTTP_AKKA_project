package app.infrastructure.Persistence.resource

import com.github.nscala_time.time.Imports.DateTime

case class TokenPersistentModel(
    val id: Option[Long] = None,
    val accessToken: String,
    val tokenType: String,
    val refreshToken: String,
    val expiresIn: Int,
    val generatedIn: DateTime
)
