package builders

import app.domain.thirdstore.{Code, RandomTextGenerator}
import com.github.nscala_time.time.Imports.DateTime
import com.github.nscala_time.time.Imports._

object BuildCode extends RandomTextGenerator {

  def anyLive(): Code = {
    new Code(
      code = Faker.text(),
      expiresIn = 10,
      generatedIn = DateTime.now() - 5.seconds,
      state = Faker.text(),
      clientId = Faker.text()
    )
  }

  def anyExpired(): Code = {
    new Code(
      code = Faker.text(),
      expiresIn = 10,
      generatedIn = DateTime.now() - 20.seconds,
      state = Faker.text(),
      clientId = Faker.text()
    )
  }

  def any(): Code = {
    Faker(anyLive(), anyExpired())
  }
}
