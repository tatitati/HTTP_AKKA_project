package builders

import scala.util.Random

object AnyFrom {
  def apply[T](item: T*): T = {
    val items = item.toVector
    items(Random.nextInt(items.length))
  }

  def text(): String = {
    Random.nextString(8)
  }
}
