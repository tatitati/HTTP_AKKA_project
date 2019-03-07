package app.domain.third

case class ThirdProfile(
              name: String,
              callback: String,
              homepage: String,
              description: String
) {
  def setName(withName: String): ThirdProfile = {
    this.copy(name = withName)
  }

  def callBack(withCallback: String): ThirdProfile = {
    this.copy(callback = withCallback)
  }

  def homepage(withHomepage: String): ThirdProfile = {
    this.copy(homepage = withHomepage)
  }

  def description(withDescription: String): ThirdProfile = {
    this.copy(description = withDescription)
  }
}
