package com.stackroute;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.service.TrackService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication

public class MuzixApplication extends SpringBootServletInitializer implements CommandLineRunner {

	private TrackService trackService;

	public MuzixApplication(TrackService trackService) {
		this.trackService = trackService;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MuzixApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MuzixApplication.class, args);
	}

	@Override
	public void run(String[] args) {
		try {
			trackService.saveTrack(new Track(1, "Pillo talk", "Zyan"));
			trackService.saveTrack(new Track(2, "Aaja", "Nucleya"));
		} catch (TrackAlreadyExistsException e) {
			e.printStackTrace();
		}
	}
}