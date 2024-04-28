package com.artgallery.artgallery02.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.artgallery.artgallery02.repositories")
// @PropertySource("persistence-h2.properties")
// @PropertySource("persistence-hsqldb.properties")
// @PropertySource("persistence-derby.properties")
// @PropertySource("persistence-sqlite.properties")
public class DBConfig {

  @Autowired
  private Environment env;

  @Bean
  public DataSource dataSource() {
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.sqlite.JDBC");
    dataSourceBuilder.url("jdbc:sqlite:mydb.db");
    return dataSourceBuilder.build();
  }
  // DataSource dataSource() {
  // final DriverManagerDataSource dataSource = new DriverManagerDataSource();
  // dataSource.setDriverClassName(env.getProperty("driverClassName"));
  // dataSource.setUrl(env.getProperty("url"));
  // dataSource.setUsername(env.getProperty("user"));
  // dataSource.setPassword(env.getProperty("password"));
  // return dataSource;
  // }
}

@Configuration
@Profile("h2")
@PropertySource("classpath:persistence-h2.properties")
class H2Config {
}

@Configuration
@Profile("hsqldb")
@PropertySource("classpath:persistence-hsqldb.properties")
class HsqldbConfig {
}

@Configuration
@Profile("sqlite")
@PropertySource("classpath:persistence-sqlite.properties")
class SqliteConfig {

}

// @Configuration
// public class DbConfig {

// @Bean
// public DataSource dataSource() {
// DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
// dataSourceBuilder.driverClassName("org.sqlite.JDBC");
// dataSourceBuilder.url("jdbc:sqlite:main.sqlite");
// return dataSourceBuilder.build();
// }
// }
