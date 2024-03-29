package org.tolgasumer.boilerplate.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.tolgasumer.boilerplate.domain.user.UpdateUserRequest
import org.tolgasumer.boilerplate.domain.user.User
import org.tolgasumer.boilerplate.domain.user.UserId
import org.tolgasumer.boilerplate.repository.UserRepository

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
    fun updateUser(id: UserId, req: UpdateUserRequest): User? {
        val existingUser = userRepository.findById(id)
        if (existingUser.isPresent) {
            val updatedUser = existingUser.get().update(
                displayName = req.displayName,
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
