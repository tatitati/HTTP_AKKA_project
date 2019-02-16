package test.builders

import app.domain.RandomTextGenerator
import app.domain.thirdstore.resourcestore.Code
import com.github.nscala_time.time.Imports.DateTime
import com.github.nscala_time.time.Imports._

object BuildCode extends RandomTextGenerator {

  def anyLive(withCode: String = Faker.text(), withState: String = Faker.text()): Code = {
    new Code(
      code = withCode,
      expiresIn = 10,
      generatedIn = DateTime.now() - 5.seconds,
      state = withState
    )
  }
}
