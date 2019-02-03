package app.ui.controllers

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.routing.Router
import org.scalatest.{Matchers, WordSpec}


/**
  * Created by madhu on 8/11/15.
  */
class HelloSpec extends WordSpec with Matchers with ScalatestRouteTest {
  "Customer API" should {
    "Posting to /customer should add the customer" in {
      Get("/hello") ~> Router.route ~> check {
        status shouldBe StatusCodes.OK
        responseAs[String] shouldBe "all tutorials"
      }

    }

  }
}
