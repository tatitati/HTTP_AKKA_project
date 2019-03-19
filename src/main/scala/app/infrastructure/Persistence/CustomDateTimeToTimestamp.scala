package app.infrastructure.Persistence

import slick.jdbc.MySQLProfile.api._
import java.sql.Timestamp
import com.github.nscala_time.time.Imports.DateTime

object CustomDateTimeToTimestamp {
  implicit def dateTimeMapper = MappedColumnType.base[DateTime, Timestamp](
    { datetimeObject => new Timestamp(datetimeObject.getMillis)},
    { timestampSql => new DateTime(timestampSql.getTime) }
  )
}
