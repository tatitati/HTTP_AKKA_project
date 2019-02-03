import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object WebServer {
  def main(args: Array[String]) {

    implicit val actorSystem = ActorSystem("my-system")
    implicit val actorMaterializer = ActorMaterializer()

    val route =
      path("hello") {
        get {
          complete(
            "Say hello to akka-http"
          )
        }
      }

    Http().bindAndHandle(route, "localhost", 8080)
  }
}