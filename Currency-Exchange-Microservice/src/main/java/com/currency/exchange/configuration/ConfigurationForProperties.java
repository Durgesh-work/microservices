package com.currency.exchange.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "currency-exchange-microservice")
public class ConfigurationForProperties {
	private int minimum;
	private int maximum;
}
