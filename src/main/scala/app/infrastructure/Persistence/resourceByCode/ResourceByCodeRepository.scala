package app.infrastructure.Persistence.resourceByCode

import app.domain.resource.ResourceByCode
import com.redis.RedisClient

class ResourceByCodeRepository(val redisClient: RedisClient) {

  def save(resourceByCode: ResourceByCode, expiryTime: Int = 60): Boolean = {

    val memento = resourceByCode.memento()
    redisClient.setex(
      key = memento.code,
      expiry = expiryTime,
      value = ResourceByCodeSerializer.toJson(resourceByCode)
    )
  }

  def read(code: String): Option[ResourceByCode] = {
    redisClient.get(code) match {
      case Some(value) => Some(ResourceByCodeSerializer.toDomain(value))
      case None => None
    }
  }
}
