package com.stackroute.muzixsql;

import com.stackroute.muzixsql.domain.Track;
import com.stackroute.muzixsql.exception.TrackAlreadyExistsException;
import com.stackroute.muzixsql.service.TrackService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class MuzixSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuzixSqlApplication.class, args);
	}
}