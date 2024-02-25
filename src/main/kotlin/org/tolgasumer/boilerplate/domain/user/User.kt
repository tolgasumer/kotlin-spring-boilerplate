package org.safa.sparkr.domain.user

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.safa.sparkr.domain.BaseEntity

@Entity
@Table(name = "user")
class User : BaseEntity() {
    @EmbeddedId
    val id: UserId = UserId()

    @Column(name = "username")
    var username = ""

    fun update(username: String): User {
        this.username = username
        return this
    }
}