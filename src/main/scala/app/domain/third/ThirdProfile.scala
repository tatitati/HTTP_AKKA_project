package app.domain.third

class ThirdProfile(
              private var name: String,
              private var callback: String,
              private var homepage: String,
              private var description: String
                  ) {
  def updateName(withName: String): Unit = {
    name = withName
  }

  def updateCallbackUrl(withCallback: String): Unit = {
    callback = withCallback
  }

  def updateHomepage(withHomepage: String): Unit = {
    homepage = withHomepage
  }

  def updateDescription(withDescription: String): Unit = {
    description = withDescription
  }

  def memento: ThirdProfileMemento = {
    ThirdProfileMemento(
      name,
      callback,
      homepage,
      description
    )
  }
}
