package com.team.three.users.config;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Configuration
@EnableTransactionManagement
public class R2dbcConfig extends AbstractR2dbcConfiguration {
    @Bean
    public ConnectionFactory connectionFactory() {
        log.info(">>>>dbConnection");
        return MySqlConnectionFactory.from(
                MySqlConnectionConfiguration.builder().host("13.125.131.1")
                        .password("conThree123*").port(3306).database("users").username("teamthree").build()
        );
    }
}
