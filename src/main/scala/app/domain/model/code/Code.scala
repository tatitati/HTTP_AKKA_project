package app.domain.code

import app.domain.model.code.{CodeId, CodeScope}
import app.domain.model.user.UserId
import app.domain.model.third.ThirdId

case class Code(
                 val codeId: CodeId,
                 val ownerId: UserId,
                 val thirdId: ThirdId,
                 val state: String,
                 val scope: CodeScope
)