package ch.alex.webservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

public class Application extends RepositoryRestMvcConfiguration{

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
}
