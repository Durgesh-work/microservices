package com.example.demo.entity;

import java.time.LocalDate;


import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

	private Integer id;
	
	@Size(min = 2, max = 20, message = "name must be between 2 and 20")
	private String name;
	
	@Past
	private LocalDate birthDate;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	

}
