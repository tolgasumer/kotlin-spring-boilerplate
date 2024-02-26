package org.tolgasumer.boilerplate

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@Testcontainers
@SpringBootTest
class BaseIntegrationTest {
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