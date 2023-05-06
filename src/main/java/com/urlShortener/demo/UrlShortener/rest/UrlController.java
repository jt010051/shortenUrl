package com.urlShortener.demo.UrlShortener.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlShortener.demo.UrlShortener.domain.URL;
import com.urlShortener.demo.UrlShortener.repositories.UrlRepository;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/url")
public class UrlController {
	@Autowired
	UrlRepository urlRepo;
	
	
	
	 @GetMapping("/message")
	    public String testMessage(){
	        return "Hello World";
	    }
	 @GetMapping("allUrls")
		public List<URL> getAllUrls(HttpServletResponse response) {
			return urlRepo.findAll();
		}
}
