package com.javatechie.microservice.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.microservice.api.book.Book;
import com.javatechie.microservice.api.book.Repository.BookRepository;
import com.javatechie.microservice.api.user.User;
import com.javatechie.microservice.api.user.Repository.UserRepository;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class SpringBootMultipleDatasourceApplication {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;

	@PostConstruct
	public void dataInitializer() {
		userRepository
				.saveAll(Stream.of(new User(987, "Basanta"), new User(445, "Santosh")).collect(Collectors.toList()));
		bookRepository.saveAll(Stream.of(new Book(887, "Java"), new Book(567, "Spring")).collect(Collectors.toList()));
	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultipleDatasourceApplication.class, args);
	}
}
