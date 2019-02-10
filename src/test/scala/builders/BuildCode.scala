package builders

import app.domain.thirdstore.{Code, RandomTextGenerator}
import com.github.nscala_time.time.Imports.DateTime
import com.github.nscala_time.time.Imports._

object BuildCode extends RandomTextGenerator {

  def anyLive(withCode: String = Faker.text()): Code = {
    new Code(
      code = withCode,
      expiresIn = 10,
      generatedIn = DateTime.now() - 5.seconds,
      state = Faker.text(),
      clientId = Faker.text()
    )
  }

  def anyExpired(withCode: String = Faker.text()): Code = {
    new Code(
      code = withCode,
      expiresIn = 10,
      generatedIn = DateTime.now() - 20.seconds,
      state = Faker.text(),
      clientId = Faker.text()
    )
  }

  def any(withCode: String = Faker.text()): Code = {
    Faker(
      anyLive(withCode = withCode),
      anyExpired(withCode = withCode)
    )
  }
}
