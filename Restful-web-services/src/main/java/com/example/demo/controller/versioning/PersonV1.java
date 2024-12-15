package com.example.demo.controller.versioning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonV1 {
 private String name;

@Override
public String toString() {
	return "PersonV1 [name=" + name + "]";
}
 
}
