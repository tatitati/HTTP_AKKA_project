package app.domain.factories

import app.domain.RandomTextGenerator
import app.domain.resourcestore.Code
import com.github.nscala_time.time.Imports.DateTime

object FactoryCode extends RandomTextGenerator {

  def create(state: String): Code = {
    new Code(
      code = makeRandomText(),
      generatedIn = DateTime.now(),
      state = state
    )
  }
}
