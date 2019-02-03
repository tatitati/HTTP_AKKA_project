package app.domain.thirdstore

class MementoToken(
            val accessToken: String,
            val tokenType: String,
            val refreshToken: String,
            val expiresIn: Int
    ) {

}
