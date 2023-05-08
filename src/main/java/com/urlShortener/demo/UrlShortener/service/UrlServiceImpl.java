package com.urlShortener.demo.UrlShortener.service;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.urlShortener.demo.UrlShortener.domain.URL;
import com.urlShortener.demo.UrlShortener.repositories.UrlRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UrlServiceImpl implements URLService {
private final UrlRepository repository;
	@Override
	public URL create(URL url) {
		log.info("Saving new url{}:", url.getShortUrl());
		
		return repository.save(url);
	}

	@Override
	public URL get(Long id) {
		log.info("Fetching url by id{}", id);
		return repository.findById(id).get();
	}
	
	

}
