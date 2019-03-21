package test.app.domain.ownerstore

import builders.domain.BuildOwnerProfile
import org.scalatest.FunSuite
import com.github.nscala_time.time.Imports.DateTime

class OwnerProfileSpec extends FunSuite {

  test("Has proper attributes") {
    val givenProfile = BuildOwnerProfile.any(
      withFirstname = "anyfirstname"
    )

    assert(givenProfile.memento.firstname === "anyfirstname")
    assert(givenProfile.memento.datebirth.isInstanceOf[DateTime])
  }
}
