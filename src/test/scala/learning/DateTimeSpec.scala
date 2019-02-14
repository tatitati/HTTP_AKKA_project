package learning

import com.github.nscala_time.time.Imports._
import org.scalatest.FunSuite

class DateTimeSpec extends FunSuite {

  test("Create a date") {
    val date = DateTime.now()
    assert(date.isInstanceOf[DateTime])
  }

  test("Compare two dates") {
    val now = DateTime.now()
    val dateFuture = DateTime.now() + 2.months

    assert(now < dateFuture)
  }

  test("Create an specific date in multiple ways") {
    val specificdate1 = new DateTime()
      .withYear(2030)
      .withMonth(8)
      .withDay(20)

    val specificdate2 = new DateTime()
      .withDate(2030, 8, 20)
      .withTime(13, 8, 20, 400)

    assert(specificdate1.getYear === 2030)
    assert(specificdate2.getMonthOfYear === 8)
  }

  test("Format an string in an specific format") {
    val specificdate = new DateTime()
      .withDate(2030, 8, 20)
      .withTime(13, 8, 20, 400)

    assert(specificdate.toString === "2030-08-20T13:08:20.400+01:00")
    assert(specificdate.toString("Y-M--d") === "2030-8--20")
  }

  //
  // Parsing dates from string
  //

  test("Parse string to DateTime") {
    val parsed = DateTime.parse("2030-08-20T13:08:20.400+01:00")

    assert(parsed.isInstanceOf[DateTime])
    assert(parsed.toString() === "2030-08-20T13:08:20.400+01:00")
  }

  test("Parse string in different formats") {
    val parsed = DateTime.parse("2030-08")

    assert(parsed.isInstanceOf[DateTime])
    assert(parsed.toString() === "2030-08-01T00:00:00.000+01:00")
  }

  test("Parse string with a custom formatter") {
    val parsed: DateTime = DateTime.parse("2030****08", DateTimeFormat.forPattern("yyyy****dd"))

    assert(parsed.isInstanceOf[DateTime])
    assert(parsed.toString() === "2030-01-08T00:00:00.000Z")
  }

  //
  // From an string I can get the same precission than a datetime created object
  //
  test("From an string I can get the same object") {
    val specificdate = new DateTime()
      .withDate(2030, 8, 20)
      .withTime(13, 8, 20, 400)

    val parsed = DateTime.parse("2030-08-20T13:08:20.400+01:00")

    assert(parsed.toString() === "2030-08-20T13:08:20.400+01:00")
    assert(parsed.isEqual(specificdate))
  }
}
