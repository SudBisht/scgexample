package com.bsb.portal.secure;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfiguration {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		// @formatter:off
		return http
        .csrf().disable()
        .authorizeExchange()
        .matchers(PathRequest.toStaticResources().atCommonLocations())
        .permitAll()
        .pathMatchers(HttpMethod.POST, "/bsb/portal/get", "/my/web/ser/api/v1/messages/send", "/bsb/web/data/api/v1/messages/send")
        .permitAll()
        .pathMatchers(HttpMethod.GET, "/bsb/web/data/**", "/my/web/ser/**")
        .permitAll()
        .pathMatchers(HttpMethod.POST, "/bsb/web/data/**", "/my/web/ser/**")
        .authenticated()
        .anyExchange()
        .authenticated()
        .and()
        .httpBasic()
        .and()
        .build();
	  // @formatter:on
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
