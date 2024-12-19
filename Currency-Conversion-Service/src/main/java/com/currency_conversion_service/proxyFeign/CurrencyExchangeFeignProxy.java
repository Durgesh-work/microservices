package com.currency_conversion_service.proxyFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.currency_conversion_service.entity.CurrencyConversion;

@FeignClient(name = "currency-exchange-microservice")
public interface CurrencyExchangeFeignProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
