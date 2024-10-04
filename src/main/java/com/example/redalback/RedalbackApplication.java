package com.example.redalback;

import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedalbackApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RedalbackApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {;
	}
}
