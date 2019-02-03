package builders

import app.domain.thirdstore.Third
import org.scalatest.FunSuite
import test.builders.BuilderThird

class BuilderThirdSpec extends FunSuite {
  test("Builder can create a user") {
    assert(
      BuilderThird.any().isInstanceOf[Third]
    )
  }
}
