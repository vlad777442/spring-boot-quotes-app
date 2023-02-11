package com.kameleoon.quotesmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuotesManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotesManagerApplication.class, args);
	}

}
