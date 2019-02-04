package app.domain

import com.github.nscala_time.time.Imports._

class Profile(
               val firstname: String,
               val surname: String,
               val email: String,
               val emailconfirmed: Boolean,
               val datebirth: DateTime
             ) {

}
