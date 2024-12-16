package com.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.limitservice.configuration.ConfigurationForProperties;
import com.limitservice.entity.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	private ConfigurationForProperties confForProperties;

	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(confForProperties.getMinimum(), confForProperties.getMaximum());
		// return new Limits(1,1000);
	}
}
