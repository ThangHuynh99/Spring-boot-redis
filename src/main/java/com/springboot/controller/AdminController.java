package com.springboot.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin")
public class AdminController {
	
	@GetMapping("/hello")
	@Secured("ROLE_ADMIN")
	public String helloAdmin() {
		return "Hello đây là trang admin";
	}
}
