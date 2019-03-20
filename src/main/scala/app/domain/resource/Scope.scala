package app.domain.resource

import app.domain.IdentifiableInPersistence

case class Scope(
                  val firstname: Boolean,
                  val surname: Boolean,
                  val email: Boolean
  ) extends IdentifiableInPersistence {

  if(!firstname && !surname && !email) {
    throw new IllegalArgumentException("An scope that forbid everything doesnt make sense")
  }
}
