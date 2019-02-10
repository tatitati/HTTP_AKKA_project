//package app.domain.thirdstore
//
//import java.util.UUID
//import app.domain.{Scope, Token}
//import app.domain.ownerstore.OwnerProfile
//import com.github.nscala_time.time.Imports.DateTime
//
//class ResourceCode(
//                     private val ownerProfile: OwnerProfile,
//                     private val scope: Scope,
//                     var code: Code
//                   ){
//
//  @throws(classOf[IllegalAccessException])
//  def isCodeExpired(): Boolean = code match {
//    case Some(token) => code.isExpired
//    case _ => throw new IllegalAccessException("There is no token. Cannot be possible to know if is expired.")
//  }
//
//  def exportResourceToken(): ResourceToken = {
//
//  }
//}
