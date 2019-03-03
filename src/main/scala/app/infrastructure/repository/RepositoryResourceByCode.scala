package app.infrastructure.repository

import app.domain.thirdstore.resourcestore.ResourceByCode
import app.infrastructure.serializer.SerializerResourceByCode
import com.redis.RedisClient

class RepositoryResourceByCode(val redisClient: RedisClient) {

  def save(resourceByCode: ResourceByCode): Boolean = {

    val memento = resourceByCode.exportMemento()

    redisClient.setex(
      key = memento.code,
      expiry = 60,
      value = SerializerResourceByCode.toJson(resourceByCode)
    )
  }
}
