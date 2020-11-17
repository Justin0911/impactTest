package com.numbersequencesummarizer.numbersequencesummarizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@ComponentScan({
	"com.numbersequencesummarizer.numbersequencesummarizer.getAPI",
	"com.numbersequencesummarizer.numbersequencesummarizer.sequenceSummary",
	"com.numbersequencesummarizer.numbersequencesummarizer.summarizerService"})

public class NumbersequencesummarizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumbersequencesummarizerApplication.class, args);
	}

}