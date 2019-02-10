package app.domain.thirdstore

import java.util.UUID
import app.domain.{Scope, Token}
import app.domain.ownerstore.OwnerProfile
import com.github.nscala_time.time.Imports.DateTime

class ResourceCode(
                     private val ownerProfile: OwnerProfile,
                     private val scope: Scope,
                     private val code: Code
                   ){

  def isCodeExpired(): Boolean = {
    code.isExpired
  }

//  def exportResourceToken(): ResourceToken = {
//
//  }
}
