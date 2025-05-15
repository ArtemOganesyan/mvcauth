package com.example.mvcauth;

import com.example.mvcauth.entity.User;
import com.example.mvcauth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MvcauthApplication {

	@Bean
	CommandLineRunner init(UserRepository repo, BCryptPasswordEncoder encode) {
		return args -> {
			if (repo.findByUsername("testuser") == null) {
				User user = new User();
				user.setUsername("testuser");
				user.setPassword(encode.encode("password"));
				repo.save(user);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcauthApplication.class, args);
	}

}
