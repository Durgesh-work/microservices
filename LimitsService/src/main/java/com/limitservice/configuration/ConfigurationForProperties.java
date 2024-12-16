package com.limitservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "limits-service")
public class ConfigurationForProperties {
	private int minimum;
	private int maximum;
}
