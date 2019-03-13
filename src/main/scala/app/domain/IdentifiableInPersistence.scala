package app.domain

abstract class IdentifiableInPersistence {
  private var surrogateId: Option[Long] = None

  def setSurrogateId(withSurrogateId: Long): Unit = {
    if(surrogateId != None) {
      throw new IllegalArgumentException("Surrogate ID cannot be modified once that is set")
    }

    surrogateId = Some(withSurrogateId)
  }

  protected def getSurrogateId(): Option[Long] = {
    surrogateId
  }
}
