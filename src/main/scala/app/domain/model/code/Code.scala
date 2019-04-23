package app.domain.code

import app.domain.model.Scope
import app.domain.model.thirdapp.SiteId
import app.domain.model.code.CodeId
import app.domain.model.user.UserId

case class Code(
                 val codeId: CodeId,
                 val userId: UserId,
                 val siteId: SiteId,
                 val state: String,
                 val scope: Scope
)