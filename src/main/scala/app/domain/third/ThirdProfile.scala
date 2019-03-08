package app.domain.third

case class ThirdProfile(
              name: String,
              callback: String,
              homepage: String,
              description: String
) {
  def updateName(withName: String): ThirdProfile = {
    this.copy(name = withName)
  }

  def updateCallbackUrl(withCallback: String): ThirdProfile = {
    this.copy(callback = withCallback)
  }

  def updateHomepage(withHomepage: String): ThirdProfile = {
    this.copy(homepage = withHomepage)
  }

  def updateDescription(withDescription: String): ThirdProfile = {
    this.copy(description = withDescription)
  }
}
