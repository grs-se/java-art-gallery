package com.artgallery.artgallery02.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artgallery.artgallery02.models.Artwork;
import com.artgallery.artgallery02.repositories.ArtworkRepository;

@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ArtworkRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Artwork("Still life with fruit", "oil on canvas", "painting")));
      log.info("Preloading " + repository.save(new Artwork("The Head of Medusa", "oil on canvas", "painting")));
    };
  }
}
