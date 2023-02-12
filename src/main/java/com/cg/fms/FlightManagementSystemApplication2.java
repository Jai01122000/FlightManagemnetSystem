package com.cg.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info (title = "Flight Management System",contact = @Contact(name = "Jai",email = "jai-kumar.s-d@capgemini.com")))
public class FlightManagementSystemApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemApplication2.class, args);
	}
	@Bean("rt")
	public RestTemplate getRT(){
		RestTemplate rt = new RestTemplate();
		return rt;
	}

}
