package com.coursework.bookshop;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Log4j2
@SpringBootApplication
@EnableJpaRepositories
public class BookshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopApplication.class, args);
//		log.trace("Trace");
//		log.debug("Debug");
//		log.info("info");
//		log.warn("warn");
//		log.error("error");
//		log.fatal("fatal");
	}

}
