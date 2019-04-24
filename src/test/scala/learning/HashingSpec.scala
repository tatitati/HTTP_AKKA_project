package learning

import org.scalatest.FunSuite
import java.security.MessageDigest

class HashingSpec extends FunSuite {

  test("I can has a simple string") {
    val text = "goodbyee"

    val hashed = MessageDigest.getInstance("SHA-256")
      .digest("some string".getBytes("UTF-8"))
      .map("%02x".format(_)).mkString

    assert(hashed == "61d034473102d7dac305902770471fd50f4c5b26f6831a56dd90b5184b3c30fc")
  }

  test("The hash is always the same") {
    val text = "goodbyee"

    val hashed1 = MessageDigest.getInstance("SHA-256")
      .digest("some string".getBytes("UTF-8"))
      .map("%02x".format(_)).mkString

    val hashed2 = MessageDigest.getInstance("SHA-256")
      .digest("some string".getBytes("UTF-8"))
      .map("%02x".format(_)).mkString

    assert(hashed1 == hashed2)
  }
}
