package org.tolgasumer.boilerplate

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

class CustomPostgreSQLContainer(imageName: String) : PostgreSQLContainer<CustomPostgreSQLContainer>(imageName)

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BaseIntegrationTest {
    @Autowired
    protected lateinit var mockMvc: MockMvc

    companion object {
        @Container
        @JvmStatic
        val postgres: CustomPostgreSQLContainer = CustomPostgreSQLContainer("postgres:latest")

        @BeforeAll
        @JvmStatic
        fun setUp() {
            postgres.start()
            System.setProperty("spring.datasource.url", postgres.jdbcUrl)
            System.setProperty("spring.datasource.username", postgres.username)
            System.setProperty("spring.datasource.password", postgres.password)
        }

        @AfterAll
        @JvmStatic
        fun tearDown() {
            postgres.stop()
        }
    }

    @Test
    fun `postgres container is running`() {
        Assertions.assertTrue(postgres.isRunning)
    }
}