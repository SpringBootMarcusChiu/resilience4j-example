package com.marcuschiu.resilience4jexample;

import com.marcuschiu.resilience4jexample.client.RemoteServiceAClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Resilience4jExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Resilience4jExampleApplication.class, args);
	}

	@Autowired
	RemoteServiceAClient remoteServiceAClient;

	@Async
	@Scheduled(cron = "*/10 * * * * *")
	@RequestMapping("/1-all")
	public String all() throws InterruptedException {
		return remoteServiceAClient.call6();
	}
}
