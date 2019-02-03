package app.ui.controllers

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}
import akka.http.scaladsl.model.StatusCodes
import app.ui.controller.Hello

/**
  * Created by madhu on 8/11/15.
  */
class HelloSpec extends WordSpec with Matchers with ScalatestRouteTest  {
  "Customer API" should {
    "Posting to /hello" in {

      Get("/hello") ~> Hello.helloRoute ~> check {
        status shouldBe StatusCodes.OK
        responseAs[String] shouldEqual "Say hello to akka-http"

      }

    }

  }
}
