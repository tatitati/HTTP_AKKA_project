package app.infrastructure.repository.third

case class ThirdPersistedModel(
                                id: Option[Int] = None,
                                name: String,
                                callback: String,
                                homepage: String,
                                description: String,
                                clientId: String,
                                clientSecret: String
                              )
