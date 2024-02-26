package org.tolgasumer.boilerplate.domain.user

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.*

@Embeddable
data class UserId(
    @Column(name = "id", nullable = false, updatable = false)
    var value: UUID = UUID.randomUUID()
) : Serializable {
    constructor(id: String) : this() {
        this.value = UUID.fromString(id)
    }
}