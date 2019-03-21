package app.domain.resource

import java.util.UUID

import com.github.nscala_time.time.Imports.DateTime

case class ResourceByCodeMemento(
                                  // third
                                  val thirdSurrogateId: Long,
                                  val thirdUuid: UUID,
                                  val thirdProfileName: String,
                                  val thirdClientId: String,
                                  val thirdClientSecret: String,
                                  val thirdCallback: String,
                                  val thirdHomepage: String,
                                  val thirdDescription: String,
                                  // owner
                                  val ownerFirstname: String,
                                  val ownerSurname: String,
                                  val ownerEmail: String,
                                  val ownerEmailconfirmed: Boolean,
                                  val ownerDatebirth: DateTime,
                                  // scope
                                  val scopeFirstname: Boolean,
                                  val scopeSurname: Boolean,
                                  val scopeEmail: Boolean,
                                  // code
                                  val code: String,
                                  val codeExpiresin: Int,
                                  val codeGeneratedIn: DateTime,
                                  val codeState: String,
                           )
