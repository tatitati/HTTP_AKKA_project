package app.domain.code

import app.domain.model.Scope
import app.domain.model.app.AppId
import app.domain.model.code.CodeId
import app.domain.model.user.UserId

case class Code(
                 val codeId: CodeId,
                 val userId: UserId,
                 val appId: AppId,
                 val state: String,
                 val scope: Scope
)