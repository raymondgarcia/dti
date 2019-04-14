package com.eventui.customer.tracking.club.customertrackerclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@EnableMongoAuditing
public class CustomerTrackerClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerTrackerClubApplication.class, args);
	}

}

