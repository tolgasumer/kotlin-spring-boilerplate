package org.safa.sparkr.domain.user

import jakarta.persistence.Column
import java.io.Serializable
import java.util.*

data class UserId(
    @Column(name = "user_id")
    val id: UUID = UUID.randomUUID()
) : Serializable