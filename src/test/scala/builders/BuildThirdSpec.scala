package builders

import app.domain.thirdstore.Third
import org.scalatest.FunSuite

class BuildThirdSpec extends FunSuite {
  test("Builder can create a user") {
    assert(
      BuildThird.any().isInstanceOf[Third]
    )
  }
}
