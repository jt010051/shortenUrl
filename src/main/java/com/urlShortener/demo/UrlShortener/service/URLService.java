package com.urlShortener.demo.UrlShortener.service;

import com.urlShortener.demo.UrlShortener.domain.URL;

public interface URLService {
	URL create (URL url);
	URL get(Long id);
	
}
