package org.tolgasumer.boilerplate.domain.user

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.tolgasumer.boilerplate.domain.BaseEntity

@Entity
@Table(name = "`user`")
data class User(
    @EmbeddedId
    val id: UserId = UserId(),

    @Column(name = "display_name")
    var displayName: String
) : BaseEntity() {
    fun update(displayName: String): User {
        this.displayName = displayName
        return this
    }
}
