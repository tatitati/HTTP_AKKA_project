package builders

import app.domain.RandomTextGenerator
import app.domain.thirdstore.Code
import com.github.nscala_time.time.Imports.DateTime
import com.github.nscala_time.time.Imports._

object BuildCode extends RandomTextGenerator {

  def anyLive(withCode: String = Faker.text()): Code = {
    new Code(
      code = withCode,
      expiresIn = 10,
      generatedIn = DateTime.now() - 5.seconds,
      state = Faker.text()
    )
  }
}
