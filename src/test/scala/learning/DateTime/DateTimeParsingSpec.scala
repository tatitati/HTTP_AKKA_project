package learning.DateTime

import com.github.nscala_time.time.Imports._
import org.scalatest.FunSuite

class DateTimeParsingSpec extends FunSuite {

  test("Parse string to DateTime") {
    val parsed1 = DateTime.parse("2030-08-20T13:08:20.400+01:00")
    val parsed2 = DateTime.parse("2030-08")

    assert(parsed1.isInstanceOf[DateTime])
    assert(parsed2.isInstanceOf[DateTime])

    assert(parsed1.toString() === "2030-08-20T13:08:20.400+01:00")
    assert(parsed2.toString() === "2030-08-01T00:00:00.000+01:00")
  }

  test("Parse string with a custom formatter") {
    val parsed: DateTime = DateTime.parse("2030****08", DateTimeFormat.forPattern("yyyy****dd"))

    assert(parsed.isInstanceOf[DateTime])
    assert(parsed.toString() === "2030-01-08T00:00:00.000Z")
  }

  test("I can parse a date from the string with no lost of precission") {
    val specificdate = new DateTime()
      .withDate(2030, 8, 20)
      .withTime(13, 8, 20, 400)

    val parsed = DateTime.parse("2030-08-20T13:08:20.400+01:00")

    assert(parsed.toString() === "2030-08-20T13:08:20.400+01:00")
    assert(parsed.isEqual(specificdate))
  }
}
