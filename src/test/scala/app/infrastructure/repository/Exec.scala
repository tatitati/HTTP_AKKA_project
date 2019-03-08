package app.infrastructure.repository

import slick.dbio.DBIO
import slick.jdbc.JdbcProfile
import scala.concurrent.duration._
import scala.concurrent.Await

trait Exec {
  def exec[T](action: DBIO[T])(implicit db: JdbcProfile#Backend#Database): T =
  {
    val future = db.run(action)
    Await.result(future, 2.seconds)
  }
}
