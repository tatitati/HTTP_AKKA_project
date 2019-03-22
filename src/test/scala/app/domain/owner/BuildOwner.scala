package app.domain.owner

object BuildOwner {
    def any(
             withProfile: OwnerProfile = BuildOwnerProfile.any(),
             withAuths: Auths = BuildAuths.any()
           ):Owner  = {
      new Owner(withProfile, withAuths)
    }
}
