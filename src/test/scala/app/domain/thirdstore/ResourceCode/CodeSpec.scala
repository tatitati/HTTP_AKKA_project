package app.domain.thirdstore.ResourceCode

import builders.BuildCode
import org.scalatest.FunSuite

class CodeSpec extends FunSuite {
  test("I can create some codes") {
    val codeExpired = BuildCode.anyExpired()

    assert(codeExpired.isExpired() === true)
  }
}
