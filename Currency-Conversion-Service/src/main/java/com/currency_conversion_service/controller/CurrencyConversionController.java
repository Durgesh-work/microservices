package com.currency_conversion_service.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currency_conversion_service.entity.CurrencyConversion;
import com.currency_conversion_service.proxyFeign.CurrencyExchangeFeignProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeFeignProxy currencyExchangeFeignProxy;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable("from") String from,
															@PathVariable("to") String to,
															@PathVariable("quantity") BigDecimal quantity) {
				
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		 ResponseEntity<CurrencyConversion> response = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		 CurrencyConversion currencyConversion = response.getBody();
		 
		return new CurrencyConversion(currencyConversion.getId(),
									from,
									to,
									quantity,
									currencyConversion.getConversionMultiple(),
									quantity.multiply(currencyConversion.getConversionMultiple()),
									currencyConversion.getEnvironment()
				);
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable("from") String from,
															@PathVariable("to") String to,
															@PathVariable("quantity") BigDecimal quantity) {
				
		CurrencyConversion currencyConversion = currencyExchangeFeignProxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversion(currencyConversion.getId(),
									from,
									to,
									quantity,
									currencyConversion.getConversionMultiple(),
									quantity.multiply(currencyConversion.getConversionMultiple()),
									currencyConversion.getEnvironment()
				);
	}
}
