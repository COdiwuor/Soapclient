package com.example.soapclientcat2;

import localhost.university.GetUniversityResponse;
import localhost.university.University;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Soapclientcat2Application {

	public static void main(String[] args) {
		SpringApplication.run(Soapclientcat2Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(Client universityClient) {
		return args -> {
			String universityname = "Strathmore";
			if (args.length > 0) {
				universityname = args[0];
			}

			GetUniversityResponse response = universityClient.getUniversityResponseResponse(universityname);
			University university = response.getUniversity();
			System.err.println(

							"\n University name(s): " + university.getName() +
							"\n University Location: " + university.getLocation() +
							"\n University Year Founded: " + university.getYearFounded()
				);
			};

		}
	}