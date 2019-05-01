package test.app.learning.Redis

import org.scalatest.FunSuite
import com.redis._

class ConnectSpec extends FunSuite {

  test("redis-server is up") {
    val red = new RedisClient("localhost", 6379)
    val response = red.ping

    assert(response === Some("PONG"))
  }
}
