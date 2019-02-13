package learning

import java.sql.Timestamp

import net.liftweb.json.{DefaultFormats, Serialization}
import org.scalatest.FunSuite
import com.github.nscala_time.time.Imports._

class SerializeSpec extends FunSuite {

  test("Can serialize (to json) an object, but days have some problems") {

      val serialize = Serialization.write(Map(
          "access_token" -> "whatever",
          "refresh_token" -> 5,
          "token_type" -> DateTime.now(),
        ))(DefaultFormats)


      assert(serialize === "{\"access_token\":\"whatever\",\"refresh_token\":5,\"token_type\":{}}")
  }

  test("Can serialize (to json) an object, now dates is properly formatted") {
    val specificdate2 = new DateTime()
      .withDate(2030, 8, 20)
      .withTime(13, 8, 20, 400)

    val serialize = Serialization.write(Map(
      "access_token" -> "whatever",
      "onenumber" -> 5,
      "date" -> specificdate2.toString(),
    ))(DefaultFormats)

    assert(serialize === "{\"access_token\":\"whatever\",\"onenumber\":5,\"date\":\"2030-08-20T13:08:20.400+01:00\"}")
  }
}
