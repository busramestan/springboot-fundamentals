package com.busramestan.firstSpringBoot;

import com.busramestan.firstSpringBoot.service.MessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}

	@Bean
	CommandLineRunner run(MessageService messageService) {
		return args -> {
			messageService.sendMessage();
		};
	}

}
