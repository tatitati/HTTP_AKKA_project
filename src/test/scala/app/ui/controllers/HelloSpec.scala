package test.pp.ui.controllers

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FunSuite, Matchers}
import akka.http.scaladsl.model.StatusCodes
import app.ui.controller.Hello

/**
  * Created by madhu on 8/11/15.
  */
class HelloSpec extends FunSuite with Matchers with ScalatestRouteTest  {

    test("/ping returns pong") {
      Get("/ping") ~> Hello.helloRoute ~> check {
        status shouldBe StatusCodes.OK
        responseAs[String] shouldEqual "pong"
      }
    }
}
