package com.example.demo.controller.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
   //Url versioning
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	//Url versioning
	@GetMapping("/v2/person")
	public PersonV1 getSecondVersionOfPerson() {
		return new PersonV1("Marry");
	}
	
	//request param
	@GetMapping(path = "person", params = "verson=1") //this method will get called only when "verson=1"
	public String getMethodName() {
		return "hello person";
	}
	
	//header versioning
	@GetMapping(path = "person", headers = "X-API-VERSION=1")
	public String getPersonByHeaderVersioning() {
		return "hello person";
	}
	
}
