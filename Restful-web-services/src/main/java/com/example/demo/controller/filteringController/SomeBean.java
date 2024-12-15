package com.example.demo.controller.filteringController;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SomeBean {

	@JsonIgnore
	private String field1;
	private String field2;
	private String field3;
	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
	
}
