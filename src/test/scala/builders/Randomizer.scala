package builders

import scala.util.Random

object Randomizer {
  def any[T](items: Seq[T]): T = {
    items(Random.nextInt(items.length))
  }
}
