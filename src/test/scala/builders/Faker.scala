package test.builders

import com.github.nscala_time.time.Imports.{DateTime, _}

import scala.util.Random

object Faker {
  def apply[T](items: T*): T = {
    items(Random.nextInt(items.length))
  }

  def text(): String = {
    Random.nextString(8)
  }

  def boolean(): Boolean = {
    Random.nextBoolean()
  }

  def number(): Int = {
    Random.nextInt()
  }

  def date(): DateTime = {
    val past = DateTime.now.withYear(2000).withMonth(8).withDay(20)
    val now = DateTime.now
    val future = DateTime.now.withYear(2030).withMonth(8).withDay(20)


    val dates = Vector(past, now, future)
    dates(Random.nextInt(dates.length))
  }
}
