package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.daoservice.UserDaoService;
import com.example.demo.entity.User;
import com.example.demo.exceptions.UserNotFoundException;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		
		return userDaoService.findAll();
	}
	
	/*  @GetMapping("/users/{id}")
	public User findOne(@PathVariable("id") Integer id) {
		User user =  userDaoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException(id);
		}
		else {
			return user;
		}
	}
	 */
	
	
	//using Hateoas
		@GetMapping("/users/{id}")
		public EntityModel<User> findOneWithHateoas(@PathVariable("id") Integer id) {
			User user =  userDaoService.findOne(id);
			if(user == null) {
				throw new UserNotFoundException(id);
			}

			EntityModel<User> entityModel = EntityModel.of(user);
			WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
			entityModel.add(link.withRel("all-users"));
			return entityModel;
		}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return new ResponseEntity(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
		
		User savedUser = userDaoService.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(savedUser.getId())
							.toUri();
		
		return ResponseEntity.created(location).body(savedUser);
	}
	

}
