package test.app.infrastructure.repository

import app.infrastructure.repository.RepositoryResourceByCode
import com.redis.RedisClient
import org.scalatest.FunSuite
import test.builders.BuildResourceByCode

class RepositoryResourceByCodeSpec extends FunSuite {

  test("Can persist in redis") {
      val repo = new RepositoryResourceByCode(
        new RedisClient("localhost", 6379)
      )

      val resourceByCode = BuildResourceByCode.any()

      assert(repo.save(resourceByCode) === true)
  }
}
