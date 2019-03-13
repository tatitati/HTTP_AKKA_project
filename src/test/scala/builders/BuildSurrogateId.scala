package test.builders

object BuildSurrogateId {
  def any(): Option[Long] = {
    Faker(None, Some(23), Some(21), Some(2))
  }

  def anyNotNone(): Option[Long] = {
    Faker(Some(23), Some(21), Some(2))
  }
}
