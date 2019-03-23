package test.app.domain.model.owner

import app.domain.model.owner.OwnerId
import test.builders.Faker

object BuildOwnerId {

  def any(withValue: String = Faker.text()): OwnerId = {
    OwnerId(withValue)
  }
}
