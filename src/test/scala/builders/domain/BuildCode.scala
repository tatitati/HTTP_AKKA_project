package builders.domain

import app.domain.RandomTextGenerator
import app.domain.resource.Code
import com.github.nscala_time.time.Imports._
import test.builders.Faker

object BuildCode extends RandomTextGenerator {

  def any(
           withCode: String = Faker.text(),
           withState: String = Faker.text(),
           expiresIn: Int = 10,
           generatedIn: DateTime

         ): Code = {
    new Code(
      code = withCode,
      expiresIn = expiresIn,
      generatedIn = generatedIn,
      state = withState
    )
  }

  def anyLive(
               withCode: String = Faker.text(),
               withState: String = Faker.text()
             ): Code = {
    new Code(
      code = withCode,
      expiresIn = 10,
      generatedIn = DateTime.now() - 5.seconds,
      state = withState
    )
  }

  def specific(): Code = {
    new Code(
      code = "code",
      state = "state",
      expiresIn = 10,
      generatedIn = new DateTime("2015-02-10")
    )
  }
}