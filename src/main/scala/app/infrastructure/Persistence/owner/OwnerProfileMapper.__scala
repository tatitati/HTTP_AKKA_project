package app.infrastructure.Persistence.owner

import app.domain.owner.OwnerProfile

object OwnerProfileMapper {

  def toDomain(fromPersistent: OwnerProfilePersistModel): OwnerProfile = {
    val domain = new OwnerProfile(
        firstname = fromPersistent.firstname,
        surname = fromPersistent.surname,
        email = fromPersistent.email,
        emailconfirmed = fromPersistent.isEmailConfirmed,
        datebirth = fromPersistent.datebirth
    )

    fromPersistent.id match {
      case None => throw new IllegalArgumentException("A persisted OwnerProfile is expected to have a surrogate id in order to be mapped to domain")
      case Some(value) if value.isInstanceOf[Long] => domain.setSurrogateId(fromPersistent.id)
    }

    domain
  }

  def toPersistent(ownerProfile: OwnerProfile): OwnerProfilePersistModel= {
    new OwnerProfilePersistModel(
      id = ownerProfile.getSurrogateId(),
      firstname = ownerProfile.memento.firstname,
      surname = ownerProfile.memento.surname,
      email = ownerProfile.memento.email,
      isEmailConfirmed = ownerProfile.memento.emailconfirmed,
      datebirth = ownerProfile.memento.datebirth
    )
  }
}
