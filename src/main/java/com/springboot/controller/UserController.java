package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.UserDTO;
import com.springboot.service.IUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private IUserService iUserService;

	@ApiOperation(value = "View all user")
	@GetMapping("/user")
	public List<UserDTO> allUser() {
		return iUserService.findAll();
	}

	@GetMapping("/user/{id}")
	public UserDTO user(@PathVariable Long id) {
		return iUserService.findOneById(id);
	}

	@PostMapping("/user")
	public UserDTO insert(@RequestBody UserDTO userDTO) {
		return iUserService.save(userDTO);
	}

	@PutMapping("/user")
	public UserDTO update(@RequestBody UserDTO userDTO) {
		return iUserService.update(userDTO);
	}

	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable Long id) {
		iUserService.delete(id);
	}

}
