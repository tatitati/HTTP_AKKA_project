package learning

import com.github.nscala_time.time.Imports._
import org.scalatest.FunSuite

class DateTimeSpec extends FunSuite {

    test("I can create a date") {
      val date = DateTime.now()
      assert(date.isInstanceOf[DateTime])
    }

  test("I can create a date in the future and compare with NOW") {
    val now = DateTime.now()
    val dateFuture = DateTime.now() + 2.months

    assert(now < dateFuture)
  }

  test("I can create an specific date") {
    val now = new  DateTime()
    val specificdate = now.withYear(2030).withMonth(8).withDay(20)

    assert(specificdate.getYear === 2030)
    assert(specificdate.getMonthOfYear === 8)
  }

  test("I can create an string in an specific format") {
    val now = new  DateTime()
    val specificdate = now.withYear(2030).withMonth(8).withDay(20)

    assert(specificdate.toString("Y-M--d") === "2030-8--20")

  }
}
