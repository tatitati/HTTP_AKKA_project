package app.domain.thirdstore

class Third(
             val name: String,
             val clientid: String,
             val clientsecret: String,
             val callback: String,
             val homepage: String,
             val description: String) {

  def revoke(resource: Resource) = {

  }
}
