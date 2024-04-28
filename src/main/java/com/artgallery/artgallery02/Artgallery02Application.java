package com.artgallery.artgallery02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Artgallery02Application {

	public static void main(String[] args) {
		SpringApplication.run(Artgallery02Application.class, args);

		// ApplicationContext ctx =
		// SpringApplication.run(Artgallery02Application.class, args);

		// IArtworkService artworkService = ctx.getBean("artworkService",
		// IArtworkService.class);
	}

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
