package app.infrastructure.repository

import app.domain.thirdstore.resourcestore.ResourceByCode
import app.infrastructure.serializer.SerializerResourceByCode
import com.redis.RedisClient

class RepositoryResourceByCode(val redisClient: RedisClient) {

  def save(resourceByCode: ResourceByCode, expiryTime: Int = 60): Boolean = {

    val memento = resourceByCode.exportMemento()

    redisClient.setex(
      key = memento.code,
      expiry = expiryTime,
      value = SerializerResourceByCode.toJson(resourceByCode)
    )
  }

  def read(code: String): Option[ResourceByCode] = {
    redisClient.get(code) match {
      case Some(value) => Some(SerializerResourceByCode.toDomain(value))
      case None => None
    }
  }
}
