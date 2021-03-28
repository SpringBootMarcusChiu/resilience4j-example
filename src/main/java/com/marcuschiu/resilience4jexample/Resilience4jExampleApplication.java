package com.marcuschiu.resilience4jexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Resilience4jExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Resilience4jExampleApplication.class, args);
	}

	@Autowired
	RemoteServiceClient remoteServiceClient;

	@RequestMapping("/")
	public String someRemoteService() {
		return remoteServiceClient.call();
	}
}
