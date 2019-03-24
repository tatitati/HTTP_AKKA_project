package test.app.domain.model.auth

import java.util.UUID

import app.domain.model.auth.AuthId
import test.builders.BuildUuid

object BuildAuthId {

    def any(withValue: UUID = BuildUuid.any()): AuthId = {
        AuthId(withValue)
    }

    def any1(): AuthId = {
      any(withValue = BuildUuid.uuidOne())
    }

    def any2(): AuthId = {
      any(withValue = BuildUuid.uuidTwo())
    }
}
