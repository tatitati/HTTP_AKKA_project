package app.domain.thirdstore

import builders.BuildCode
import org.scalatest.FunSuite

class CodeSpec extends FunSuite {

  test("A code exists like LIVE or simply doesn't exist") {
    val codeExpired = BuildCode.anyLive()

    assert(codeExpired.isExpired() === false)
  }
}
