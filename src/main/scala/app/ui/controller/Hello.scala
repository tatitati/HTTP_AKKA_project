package app.ui.controller

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object Hello {

  val helloRoute =
    path("ping") {
      get {
        complete(
          "pong"
        )
      }
    }

  def main(args: Array[String]) {

    implicit val actorSystem = ActorSystem("my-system")
    implicit val actorMaterializer = ActorMaterializer()


    Http().bindAndHandle(helloRoute, "localhost", 8080)
  }
}