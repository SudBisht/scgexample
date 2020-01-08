package com.bsb.portal.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * User: Sudarshan Bisht
 * Date: 2020-01-08:20:51
 */


@RestController
@RequestMapping("bsb/portal")
public class MyController {

	@PostMapping("/get")
	public Mono<?> login(ServerHttpRequest request, ServerHttpResponse response) {

		return Mono.just("Hello User!");
	}

	@PostMapping("/set")
	public Mono<?> login1(ServerHttpRequest request, ServerHttpResponse response) {

		return Mono.just("Hello User! -- SET");
	}
}
