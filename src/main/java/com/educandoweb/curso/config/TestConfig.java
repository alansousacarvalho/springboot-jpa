package com.educandoweb.curso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.UserRepository;

@Configuration 
@Profile("test")
public class TestConfig implements CommandLineRunner { // Popular o BD.

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Alan", "alan@gmail.com", "999", "1234567");
		userRepository.save(u1);
	}
}
