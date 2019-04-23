package app.infrastructure.persistence.code

import app.domain.code.Code
import com.redis.RedisClient
import test.app.infrastructure.Persistence.code.CodeSerializer

class CodeRepository(val redisClient: RedisClient) {

  def save(code: Code, expiryTime: Int = 60): Boolean = {

    redisClient.setex(
      key = code.codeId.toString,
      expiry = expiryTime,
      value = CodeSerializer.toJson(code)
    )
  }

  def read(code: String): Option[Code] = {
    redisClient.get(code) match {
      case Some(value) => Some(CodeSerializer.toDomain(value))
      case None => None
    }
  }
}
