package builders

import org.joda.time.DateTime
import com.github.nscala_time.time.Imports._
import app.domain.thirdstore.Code

object BuilderCode {

  def anyLiveCode(): Code = {
    new Code(
      java.util.UUID.randomUUID,
      DateTime.now() - 10.seconds
    )
  }

  def anyExpiredCode(): Code = {
    new Code(
      java.util.UUID.randomUUID,
      DateTime.now() - 100.seconds
    )
  }
}
