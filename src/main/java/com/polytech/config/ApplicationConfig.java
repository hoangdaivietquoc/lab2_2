package com.polytech.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by daivietquochoang on 16/03/2017.
 */
@Configuration
@PropertySource("classpath:/application.properties")
@ComponentScan({"com.polytech.repository","com.polytech.business","com.polytech.web"})
@EntityScan("com.polytech.business")
@EnableJpaRepositories("com.polytech.repository")
public class ApplicationConfig {
    @Value("${datasource.driverName}")
    private String driverClassName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;


    @Bean
    @Profile("PROD")
    public DataSource dataSourceForProd() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }


    @Bean
    @Profile("DEV")
    public DataSource dataSourceForDev() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("create-schema.sql")
                .addScript("default-users.sql")
                .build();
    }

}
