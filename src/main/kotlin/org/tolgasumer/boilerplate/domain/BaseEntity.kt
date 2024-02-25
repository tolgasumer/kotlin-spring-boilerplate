package org.safa.sparkr.domain

import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Version
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.time.ZoneOffset
import java.time.ZonedDateTime

@MappedSuperclass
open class BaseEntity : Serializable {
    @CreationTimestamp
    val createdAt: ZonedDateTime = ZonedDateTime.now(ZoneOffset.UTC)

    @UpdateTimestamp
    val updatedAt: ZonedDateTime? = null

    @Version
    val version: Long = 0L
}