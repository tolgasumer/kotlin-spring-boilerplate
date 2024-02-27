package org.tolgasumer.boilerplate.domain.user

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.*

@Embeddable
@JsonSerialize(using = ToStringSerializer::class)
data class UserId(
    @Column(name = "id", nullable = false, updatable = false)
    var value: UUID = UUID.randomUUID()
) : Serializable {
    constructor(id: String) : this() {
        this.value = UUID.fromString(id)
    }

    override fun toString(): String {
        return value.toString()
    }
}