package org.safa.sparkr.repository

import org.safa.sparkr.domain.user.User
import org.safa.sparkr.domain.user.UserId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, UserId> {
    fun findByUsername(username: String): User?
}