package br.com.estudante.customerapi.config

import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
class FlywayMigrationConfiguration(
    @Value("\${app.flyway-maximum-pool-size}")
    private val maximumPoolSize: Int,
    private val dataSourceProperties: DataSourceProperties
) {

    @PostConstruct
    fun executeFlywayMigration() {
        val hikariDataSource = HikariDataSource()
        hikariDataSource.maximumPoolSize = maximumPoolSize
        hikariDataSource.username = dataSourceProperties.username
        hikariDataSource.jdbcUrl = dataSourceProperties.url
        hikariDataSource.password = dataSourceProperties.password
        hikariDataSource.driverClassName = dataSourceProperties.driverClassName

        val flyway = Flyway.configure().dataSource(hikariDataSource).load()

        flyway.repair()
        flyway.migrate()

        hikariDataSource.close()
    }
}
