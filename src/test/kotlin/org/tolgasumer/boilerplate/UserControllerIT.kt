package org.tolgasumer.boilerplate

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.tolgasumer.boilerplate.domain.user.User
import org.tolgasumer.boilerplate.repository.UserRepository


class UserControllerIT : BaseIntegrationTest() {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun `get User by Id`() {
        val user = userRepository.save(User())

        mockMvc.perform(get("/api/users/${user.id.value}"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.username").value(user.username));
    }
}