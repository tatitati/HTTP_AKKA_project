package test.builders

import com.github.nscala_time.time.Imports.{DateTime, _}

import scala.util.Random

object Faker {
  def apply[T](items: T*): T = {
    items(Random.nextInt(items.length))
  }

  def text(length: Int = 10): String = {
    val value = for(i <- 1 to length) yield { Random.nextPrintableChar() }
    value.mkString
  }

  def boolean(): Boolean = {
    Random.nextBoolean()
  }

  def int(): Int = {
    Random.nextInt()
  }

  def long(): Long = {
    Random.nextLong()
  }

  def date(): DateTime = {
    val past = DateTime.now.withYear(2000).withMonth(8).withDay(20)
    val now = DateTime.now
    val future = DateTime.now.withYear(2030).withMonth(8).withDay(20)


    val dates = Vector(past, now, future)
    dates(Random.nextInt(dates.length))
  }
}
