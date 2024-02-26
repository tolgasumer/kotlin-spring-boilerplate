package org.tolgasumer.boilerplate.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.tolgasumer.boilerplate.domain.user.User
import org.tolgasumer.boilerplate.domain.user.UserId
import org.tolgasumer.boilerplate.service.UserService

@RestController
@RequestMapping("/api")
class UserController(
    private val userService: UserService,
) {

    @GetMapping("/users")
    fun getAllUsers(): ResponseEntity<List<User>> {
        val users = userService.getAllUsers()
        return ResponseEntity(users, HttpStatus.OK)
    }

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable id: UserId): ResponseEntity<User> {
        val user = userService.getUserById(id)
        return ResponseEntity(user, HttpStatus.OK)
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val createdUser = userService.createUser(user)
        return ResponseEntity(createdUser, HttpStatus.CREATED)
    }

    @PutMapping("/users/{id}")
    fun updateUser(@PathVariable id: UserId, @RequestBody user: User): ResponseEntity<User> {
        val updatedUser = userService.updateUser(id, user)
        return ResponseEntity(updatedUser, HttpStatus.OK)
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: UserId): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}