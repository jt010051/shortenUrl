package com.urlShortener.demo.UrlShortener;

import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.urlShortener.demo.UrlShortener.domain.URL;
import com.urlShortener.demo.UrlShortener.repositories.UrlRepository;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	  public CommandLineRunner demo(UrlRepository repository) {

	    return (args) -> {
	      repository.save(new URL((long) Math.random()*1000, "https://www.youtube.com", "you"+"jt"+".com"));
	    
	    };
	}
}
