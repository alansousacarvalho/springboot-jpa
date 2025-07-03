package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.OrderRepository;
import com.educandoweb.curso.repositories.UserRepository;

@Configuration 
@Profile("test")
public class TestConfig implements CommandLineRunner { // Popular o BD.

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Alan", "alan@gmail.com", "999", "1234567");
		userRepository.save(u1);
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u1);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
