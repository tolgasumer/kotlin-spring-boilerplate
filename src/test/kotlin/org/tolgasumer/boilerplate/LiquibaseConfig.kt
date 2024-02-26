package org.tolgasumer.boilerplate

import liquibase.integration.spring.SpringLiquibase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

/**
 * Extra config only for testing
 * Make Liquibase use the dataSource created by Testcontainers
 */
@Configuration
class LiquibaseConfig {

    @Bean
    fun liquibase(dataSource: DataSource): SpringLiquibase {
        val liquibase = SpringLiquibase()
        liquibase.dataSource = dataSource
        liquibase.changeLog = "classpath:/liquibase/db.changelog-master.xml"
        return liquibase
    }
}