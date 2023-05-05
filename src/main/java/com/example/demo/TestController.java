package com.example.demo;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("hello")
	public ResponseEntity<String> testMethod() {
		TestController controller = WebMvcLinkBuilder.methodOn(TestController.class);
		String link = WebMvcLinkBuilder.linkTo(controller.testMethod()).toUri().toString();
		return ResponseEntity.ok(link);
	}
}
