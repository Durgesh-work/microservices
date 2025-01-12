package com.currency.exchange.controller;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency.exchange.configuration.ConfigurationForProperties;
import com.currency.exchange.entity.CurrencyExchange;
import com.currency.exchange.repository.CurrencyExchagneRepo;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private CurrencyExchagneRepo exchagneRepo;
	
	@Autowired
	private Environment environment;

	@Autowired
	private ConfigurationForProperties configurationForProperties;
	
	@GetMapping("/currencyExchange/demo")
	public Map<String, Integer> demo(){
		Map<String, Integer> map =  new LinkedHashMap<String, Integer>();
		map.put("Minimum" , configurationForProperties.getMinimum());
		map.put("Maximum" , configurationForProperties.getMaximum());
		
		return map;
	}
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
		logger.info("retrieveExchangeValue() called with {} to {}",from, to);
		
		CurrencyExchange currencyExchange= exchagneRepo.findByFromAndTo(from, to);
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to find data for: "+ from +" to "+to);
		}
		currencyExchange.setEnvironment( environment.getProperty("local.server.port"));
		
		return currencyExchange;
	}
}
