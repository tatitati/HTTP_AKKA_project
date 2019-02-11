package app.domain.thirdstore

import app.domain.Scope
import app.domain.ownerstore.OwnerProfile

class ResourceCode(
                     val thirdProfile: ThirdProfile,
                     val ownerProfile: OwnerProfile,
                     val scope: Scope,
                     private val code: Code
                   ){
}
