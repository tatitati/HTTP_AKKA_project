package app.domain.code

import app.domain.model.Scope
import app.domain.model.code.CodeId
import app.domain.model.user.UserId
import app.domain.model.third.ThirdId

case class Code(
                 val id: CodeId,
                 val userId: UserId,
                 val thirdId: ThirdId,
                 val state: String,
                 val scope: Scope
)