package com.AtpTournament.TennisAtpTournament;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TennisAtpTournamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisAtpTournamentApplication.class, args);
	}

}
