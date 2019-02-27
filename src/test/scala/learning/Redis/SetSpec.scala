package test.learning.Redis

import com.redis.RedisClient
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, FunSuite}

class SetSpec extends FunSuite with BeforeAndAfterEach with BeforeAndAfterAll {

  val red = new RedisClient("localhost", 6379)

  test("Can set key-values") {
      red.set("mykey", "my value")

      val readValue = red.get("mykey")

      assert(readValue === Some("my value"))
  }

  test("redis is wiped-out for the start of each test") {
    val readValue = red.get("mykey")

    assert(readValue === None)
  }

  test("Can set expiring keys") {
    red.set("mykey", "my value")

    val readValue1 = red.get("mykey")
    assert(readValue1 === Some("my value"))

    red.expire("mykey", 1)
    Thread.sleep(2000)

    val readValue2 = red.get("mykey")
    assert(readValue2 === None)
  }


  override def beforeAll() {
    red.flushall
    red.flushdb
  }

  override def afterEach() {
    red.flushall
    red.flushdb
  }
}
