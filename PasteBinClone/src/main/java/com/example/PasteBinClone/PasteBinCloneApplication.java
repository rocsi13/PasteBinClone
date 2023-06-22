package com.example.PasteBinClone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PasteBinCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasteBinCloneApplication.class, args);
	}
	@Autowired
	private PasteRepository repository;

}
