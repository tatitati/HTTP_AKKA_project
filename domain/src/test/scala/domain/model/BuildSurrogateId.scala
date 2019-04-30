package domain.test.model

import domain.test.builders.Faker

object BuildSurrogateId {
  def any(): Option[Long] = {
    Faker(None, Some(23), Some(21), Some(2))
  }

  def anyPersisted(): Option[Long] = {
    Faker(Some(23), Some(21), Some(2))
  }

  def anyNoPersisted(): Option[Long] = {
    None
  }
}
