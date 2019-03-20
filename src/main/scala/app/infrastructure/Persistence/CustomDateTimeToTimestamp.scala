package app.infrastructure.Persistence

import slick.jdbc.MySQLProfile.api._
import com.github.nscala_time.time.Imports.DateTime

object CustomDateTimeToTimestamp {
  implicit def dateTimeMapper = MappedColumnType.base[DateTime, String](
    { datetimeObject => datetimeObject.toString("Y-MM-dd H:mm:s") },
    { dateTimeString => DateTime.parse(dateTimeString) }
  )
}
