package learning.DateTime


import com.github.nscala_time.time.Imports._
import org.scalatest.FunSuite

class DateTimeCreationSpec extends FunSuite {

  test("Create a date") {
    val date = DateTime.now()
    assert(date.isInstanceOf[DateTime])
  }

  test("Create it using the constructor") {
    val date = new DateTime("2030-02-20T13:08:20.020Z")
    val expectedDate = new DateTime()
      .withDate(2030, 2, 20)
      .withTime(13, 8, 20, 20)

    assert(date === expectedDate)
  }

  test("Create an specific date in multiple ways") {
    val specificdate1 = new DateTime()
      .withYear(2030)
      .withMonth(8)
      .withDay(20)
      .withZone(DateTimeZone.UTC)

    val specificdate2 = new DateTime()
      .withDate(2030, 8, 20)
      .withTime(13, 8, 20, 400)
      .withZone(DateTimeZone.UTC)

    assert(specificdate1.getYear === 2030)
    assert(specificdate2.getMonthOfYear === 8)
  }

  test("Compare two dates") {
    val now = DateTime.now()
    val dateFuture = DateTime.now() + 2.months

    assert(now < dateFuture)
  }

  test("Format an string in an specific format") {

    val specificdate = new DateTime()
      .withDate(2030, 2, 20)
      .withTime(13, 8, 20, 20)

    assert(specificdate.toString === "2030-02-20T13:08:20.020Z")
    assert(specificdate.toString("Y-M--d") === "2030-2--20")
  }


}
