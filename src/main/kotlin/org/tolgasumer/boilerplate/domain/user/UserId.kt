package org.tolgasumer.boilerplate.domain.user

import java.io.Serializable
import java.util.*

data class UserId(
    val id: UUID = UUID.randomUUID()
) : Serializable