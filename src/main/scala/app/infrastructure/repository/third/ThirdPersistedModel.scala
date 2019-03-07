package app.infrastructure.repository.third

case class ThirdPersistedModel(
                                name: String,
                                callback: String,
                                homepage: String,
                                description: String,
                                clientId: String,
                                clientSecret: String
                              )
