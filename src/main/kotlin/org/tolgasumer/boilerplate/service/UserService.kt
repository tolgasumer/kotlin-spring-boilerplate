package org.safa.sparkr.service

import org.safa.sparkr.domain.user.User
import org.safa.sparkr.domain.user.UserId
import org.safa.sparkr.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    @Transactional(readOnly = true)
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun getUserById(id: UserId): User? {
        return userRepository.findById(id).orElse(null)
    }

    @Transactional
    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    @Transactional
    fun updateUser(id: UserId, user: User): User? {
        val existingUser = userRepository.findById(id)
        if (existingUser.isPresent) {
            existingUser.get()
            val updatedUser = existingUser.get().update(
                username = user.username,
            )
            return userRepository.save(updatedUser)
        }
        return null
    }

    @Transactional
    fun deleteUser(id: UserId) {
        userRepository.deleteById(id)
    }
}
