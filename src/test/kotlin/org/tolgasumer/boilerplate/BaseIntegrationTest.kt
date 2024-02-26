package org.tolgasumer.boilerplate

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.test.web.servlet.MockMvc
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class BaseIntegrationTest {
    @Autowired
    protected lateinit var mockMvc: MockMvc

    companion object {
        @Container
        @ServiceConnection
        var postgres = PostgreSQLContainer("postgres:latest")
    }

    @Test
    fun `postgres container is running`() {
        Assertions.assertTrue(postgres.isRunning)
    }
}