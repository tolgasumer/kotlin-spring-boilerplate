package org.tolgasumer.boilerplate.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.tolgasumer.boilerplate.domain.user.User
import org.tolgasumer.boilerplate.domain.user.UserId

@Repository
interface UserRepository : JpaRepository<User, UserId> {
    fun findByDisplayName(displayName: String): User?
}