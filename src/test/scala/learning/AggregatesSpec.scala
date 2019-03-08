package learning

import org.scalatest.FunSuite




class AggregatesSpec extends FunSuite {

  test("Inner entities can be updated from outside, what SHOULDNT HAPPEN ever") {

    class Image(var title: String = "title of my image")
    class IdCard(var photo: Image)

    var myidcard = new IdCard(
      new Image()
    )


    assert(myidcard.photo.title == "title of my image")

    myidcard.photo.title = "new modified title from outside"

    assert(myidcard.photo.title == "new modified title from outside")
  }

}
