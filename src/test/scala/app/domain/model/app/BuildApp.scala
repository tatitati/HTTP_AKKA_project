package app.domain.model.app

object BuildApp {

  def any(
         withCredentials: AppCredentials = BuildAppCredentials.any(),
         withProfile: AppProfile = BuildAppProfile.any()
         ): App = {

    new App(
      credentials = withCredentials,
      profile = withProfile
    )
  }


}
