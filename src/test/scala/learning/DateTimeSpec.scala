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
    val specificdate1 = new DateTime().withYear(2030).withMonth(8).withDay(20)
    val specificdate2 = new DateTime()
      .withDate(2030, 8, 20)
      .withTime(13, 8, 20, 400)

    assert(specificdate1.getYear === 2030)
    assert(specificdate1.getMonthOfYear === 8)
    assert(specificdate2.toString === "2030-08-20T13:08:20.400+01:00")
  }

  test("I can format an string in an specific format") {
    val now = new  DateTime()
    val specificdate = now.withYear(2030).withMonth(8).withDay(20)

    assert(specificdate.toString("Y-M--d") === "2030-8--20")
  }

  test("I can create a DateTime from an string") {
    val givenDateText = "2030-08-20T13:08:20.400+01:00"
    val givenDateEquivalent = new DateTime()
      .withDate(2030, 8, 20)
      .withTime(13, 8, 20, 400)

    val thenParsedDate = DateTime.parse(givenDateText)
    assert(thenParsedDate.isEqual(givenDateEquivalent) === true)
  }


}
