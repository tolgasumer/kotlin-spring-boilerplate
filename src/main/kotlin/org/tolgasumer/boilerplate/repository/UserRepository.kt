package org.tolgasumer.boilerplate.repository

import org.tolgasumer.boilerplate.domain.user.User
import org.tolgasumer.boilerplate.domain.user.UserId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, UserId> {
    fun findByUsername(username: String): User?
}