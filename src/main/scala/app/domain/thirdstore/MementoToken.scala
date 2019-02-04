package app.domain.thirdstore

case class MementoToken(val accessToken: String, val tokenType: String, val refreshToken: String, val expiresIn: Int)
