package com.gateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> routeFunction
			= p -> p.path("/get")
					.filters(f-> f.addRequestHeader("MyHeader","MyURI" )
									.addRequestParameter("MyParam", "MyValue"))
					.uri("http://httpbin.org:80");
		
			return builder.routes()
							.route(routeFunction)
							.route(p-> p.path("/currency-exchange/**")
											.uri("lb://CURRENCY-EXCHANGE-MICROSERVICE"))
							.route(p-> p.path("/currency-conversion/**")
									.uri("lb://CURRENCY-CONVERSION-SERVICE"))
							.route(p-> p.path("/currency-conversion-feign/**")
											.uri("lb://CURRENCY-CONVERSION-SERVICE"))
							.route(p-> p.path("/currency-conversion-new/**")
											.filters(f-> f.rewritePath("/currency-conversion-new/(?<segment>.*)",
																		"/currency-conversion-feign/${segment}"))
											.uri("lb://CURRENCY-CONVERSION-SERVICE"))
							.build();
	}
}
