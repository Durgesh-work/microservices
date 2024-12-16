package com.example.demo.jpaController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.jpaController.repository.UserRepository;

import jakarta.validation.Valid;


@RestController
public class DemoJpaController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> demoPost(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/jpa/users")
	public ResponseEntity<List<User>>retrieveAllUsers(){
		List<User> list = userRepository.findAll();
		
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		
	}
}
