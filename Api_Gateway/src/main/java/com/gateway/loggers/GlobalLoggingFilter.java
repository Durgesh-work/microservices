package com.gateway.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class GlobalLoggingFilter implements GlobalFilter {

	private Logger logger = LoggerFactory.getLogger(GlobalLoggingFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		logger.info("Path of the Request recieved -> {}",
					exchange.getRequest().getPath());
		
		return chain.filter(exchange);
	}

}
