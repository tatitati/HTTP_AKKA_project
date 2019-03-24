package app.domain.third

class ThirdProfile(
              var name: String,
              var callback: String,
              var homepage: String,
              var description: String
  ) {

  def memento: ThirdProfileMemento = {
    ThirdProfileMemento(
      name,
      callback,
      homepage,
      description
    )
  }
}
