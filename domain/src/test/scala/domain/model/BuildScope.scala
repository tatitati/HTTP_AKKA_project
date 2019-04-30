package domain.test.model

import domain.model.Scope
import domain.test.builders.Faker

object BuildScope {

  def onlyEmailAndFirstname(withSurrogateId: Option[Long] = None): Scope = {
    Scope(true, false, true)
  }

  def onlySurname(withSurrogateId: Option[Long] = None): Scope = {
    Scope(false, true, false)
  }

  def any(withSurrogateId: Option[Long] = None): Scope = {
    Faker(
      onlyEmailAndFirstname(withSurrogateId),
      onlySurname(withSurrogateId)
    )
  }
}
