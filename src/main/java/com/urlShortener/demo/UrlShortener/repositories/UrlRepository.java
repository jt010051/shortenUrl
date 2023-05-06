package com.urlShortener.demo.UrlShortener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urlShortener.demo.UrlShortener.domain.URL;


@Repository
public interface UrlRepository extends JpaRepository<URL, Long>{


}
