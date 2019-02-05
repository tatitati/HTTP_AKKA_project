package app.domain.thirdstore

case class ThirdProfile(
              var name: String,
              var clientid: String,
              var clientsecret: String,
              var callback: String,
              var homepage: String,
              var description: String
)
