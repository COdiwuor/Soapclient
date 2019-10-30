package com.example.soapclientcat2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import universities.wsdl.GetAllUniversitiesAtLocationResponse;
import universities.wsdl.GetAllUniversitiesResponse;
import universities.wsdl.GetUniversityResponse;
import universities.wsdl.University;

import java.util.ArrayList;

@SpringBootApplication
public class Soapclientcat2Application {

	public static void main(String[] args) {
		SpringApplication.run(Soapclientcat2Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(Client universityClient) {
		return args -> {
			String universityname = "Strathmore";
			String universitylocation = "Kiambu";
			if (args.length > 0) {
				universityname = args[0];
				universitylocation =args[0];
			}

			GetUniversityResponse response = universityClient.getUniversityResponse(universityname);
			University university = response.getUniversity();
			System.err.println(
					"\n University By Name\n"+
							"\n University name(s): " + university.getName() +
							"\n University Location: " + university.getLocation() +
							"\n University Year Founded: " + university.getYearFounded()
				);

			GetAllUniversitiesAtLocationResponse response1 = universityClient.getAllUniversitiesAtLocationResponse(universitylocation);
			University university1 = response1.getUniversity();
			System.err.println(
					"\n University By Location\n"+
					"\n University name(s): " + university1.getName() +
							"\n University Location: " + university1.getLocation() +
							"\n University Year Founded: " + university1.getYearFounded()
			);

			GetAllUniversitiesResponse response2 = universityClient.getAllUniversitiesResponse();
			ArrayList<University> alluniversities =(ArrayList<University>) response2.getUniversity();
			System.err.println("\n All Universities \n");

			int count=0;
			for (University alluniversity : alluniversities) {
				if (count==4)
						break;
				System.err.println(
						"\n University name: " + alluniversity.getName() +
								"\n University Location: " + alluniversity.getLocation() +
								"\n University Year Founded: " + alluniversity.getYearFounded()
				);
				count++;
			}


			};

		}
	}