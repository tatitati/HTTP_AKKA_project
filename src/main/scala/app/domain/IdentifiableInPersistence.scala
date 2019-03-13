package app.domain

abstract class IdentifiableInPersistence {
  private var surrogateId: Option[Long] = None

  def setSurrogateId(withSurrogateId: Option[Long]): Unit = {
    if(surrogateId != None && withSurrogateId == None) {
      throw new IllegalArgumentException("Surrogate ID cannot be modified once that is set")
    }

    surrogateId = withSurrogateId
  }

  def getSurrogateId(): Option[Long] = {
    surrogateId
  }
}
