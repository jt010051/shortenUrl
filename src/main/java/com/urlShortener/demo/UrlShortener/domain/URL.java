package com.urlShortener.demo.UrlShortener.domain;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class URL {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
	private String longUrl;
	private String shortUrl;
}
