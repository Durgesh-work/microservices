package com.limitservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Limits {

	private int minimum;
	private int maximum;
	@Override
	public String toString() {
		return "Limits [minimum=" + minimum + ", maximum=" + maximum + "]";
	}
	
	
	
}
