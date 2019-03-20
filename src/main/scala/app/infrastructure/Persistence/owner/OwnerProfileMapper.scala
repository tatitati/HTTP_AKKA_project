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

//    domain.setSurrogateId(fromPersistent.id)

    domain
  }

//  def toPersistent(third: Third): ThirdPersistModel= {
//    ThirdPersistModel(
//      id = third.getSurrogateId(),
//      name = third.getProfile.name,
//      callback = third.getProfile.callback,
//      homepage = third.getProfile.homepage,
//      description = third.getProfile.description,
//      clientId = third.getCredentials.clientId,
//      clientSecret = third.getCredentials.clientSecret
//    )
//  }
}
