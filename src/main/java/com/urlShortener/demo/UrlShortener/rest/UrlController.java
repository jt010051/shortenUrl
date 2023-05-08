package com.urlShortener.demo.UrlShortener.rest;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.urlShortener.demo.UrlShortener.domain.URL;
import com.urlShortener.demo.UrlShortener.repositories.UrlRepository;
import com.urlShortener.demo.UrlShortener.service.UrlServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/url")
public class UrlController {
	@Autowired
	UrlRepository urlRepo;
	@Autowired

	UrlServiceImpl serve;
	
	 @GetMapping("/message")
	    public String testMessage(){
	        return "Hello World";
	    }
	 @GetMapping("/allUrls")
		public List<URL> getAllUrls(HttpServletResponse response) {
			return urlRepo.findAll();
		}
	 
	 @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
	 public URL saveUrl(@RequestBody URL url, HttpServletResponse response) {
		
		;
		 url.setID((long) Math.random()*1000);
		 response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
			      .path("/findUrl/" + url.getLongUrl()).toUriString()) ;
		 
		
			 String substringUrl = url.getLongUrl().substring(0, 3);
		
			 url.setShortUrl(substringUrl +"jt");
			 

		 return serve.create(url);
	 }
}
