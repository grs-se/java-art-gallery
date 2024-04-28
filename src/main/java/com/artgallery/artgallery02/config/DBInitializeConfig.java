package com.artgallery.artgallery02.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class DBInitializeConfig {

  @Autowired
  private DataSource dataSource;

  @PostConstruct
  public void initialize() {
    try {
      Connection connection = dataSource.getConnection();
      Statement statement = connection.createStatement();
      statement.execute("DROP TABLE IF EXISTS Artworks");
      statement.executeUpdate(
          "CREATE TABLE Artworks(" +
              "id INTEGER Primary key, " +
              "title varchar(50) not null," +
              "category varchar(30) not null," +
              "medium varchar(30) not null," +
              "description varchar(200))");
      statement.executeUpdate(("INSERT INTO Artworks " +
          "(title,category,medium,description) " +
          "VALUES " + "('Mona Lisa', 'painting', 'oil on canvas', 'oil painting of woman with mysterious smile')"));
      statement.close();
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
