package com.currency.exchange.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency.exchange.configuration.ConfigurationForProperties;
import com.currency.exchange.entity.CurrencyExchange;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private ConfigurationForProperties configurationForProperties;
	
	@GetMapping("/currencyExchange/demo")
	public Map<String, Integer> demo(){
		Map<String, Integer> map =  new LinkedHashMap<String, Integer>();
		map.put("Minimum" , configurationForProperties.getMinimum());
		map.put("Maximum" , configurationForProperties.getMaximum());
		
		return map;
	}
	
	
}
