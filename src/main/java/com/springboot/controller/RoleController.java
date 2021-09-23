package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.RoleEntity;
import com.springboot.service.IRoleExample;

@RestController
@RequestMapping("/api")
public class RoleController {
	@Autowired
	private IRoleExample roleExample;
	
	@GetMapping("/role")
	public ResponseEntity<RoleEntity> getOne() {
		return ResponseEntity.ok().body(roleExample.findOne(1));
	}
	
}
