package com.bsb.portal.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User: Sudarshan Bisht
 * Date: 2020-01-08:20:54
 */

@Configuration
public class ResourceLocatorAndPostFilter {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {

		// @formatter:off
		return builder.routes()
			.route(r -> r.path("/bsb/web/data/**").and()
				.readBody(String.class, requestBody -> { return true; })
              	.filters(f -> f.rewritePath("/bsb/web/data/(?<segment>.*)", "/${segment}"))
				.uri("http://localhost:8181").id("java-test-service")).build();
			// @formatter:on
	}
}
