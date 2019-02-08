package app.domain.thirdstore

case class ThirdProfile( // a case class with VAR is not good....
              var name: String,
              var clientid: String,
              var clientsecret: String,
              var callback: String,
              var homepage: String,
              var description: String
)
