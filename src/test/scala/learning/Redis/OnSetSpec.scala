package learning.Redis

import com.redis.RedisClient
import org.scalatest.FunSuite
import com.redis._

class OnSetSpec extends FunSuite {

  val red = new RedisClient("localhost", 6379)

  test("Can set key-values") {
      red.set("mykey", "my value")

      val readValue = red.get("mykey")

      assert(readValue === Some("my value"))
  }
}
