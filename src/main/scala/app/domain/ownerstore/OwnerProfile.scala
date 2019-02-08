package app.domain.ownerstore

import com.github.nscala_time.time.Imports.DateTime

class OwnerProfile(
               var firstname: String,
               var surname: String,
               var email: String,
               val emailconfirmed: Boolean,
               var datebirth: DateTime
             )
