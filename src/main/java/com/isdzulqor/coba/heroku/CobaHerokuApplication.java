package com.isdzulqor.coba.heroku;

import com.isdzulqor.coba.heroku.config.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = {"com.isdzulqor.coba.heroku"})
public class CobaHerokuApplication {
	public static void main(String[] args) {
		SpringApplication.run(CobaHerokuApplication.class, args);
	}
}
