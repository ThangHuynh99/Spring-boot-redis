package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/user")
	public ResponseEntity<List<UserDTO>> allUser() {
		if (iUserService.findAll().size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<List<UserDTO>>(iUserService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> user(@PathVariable Long id) {
		if (iUserService.findOneById(id) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<UserDTO>(iUserService.findOneById(id), HttpStatus.OK);
	}

	
	@PostMapping("/user")
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDTO) {
		if (iUserService.save(userDTO) != null) {
			return new ResponseEntity<UserDTO>(iUserService.save(userDTO), HttpStatus.OK);
		}
		return new ResponseEntity<UserDTO>(HttpStatus.CONFLICT);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/user")
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
		try {
			 iUserService.update(userDTO);
			 return ResponseEntity.ok().body(iUserService.update(userDTO));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			iUserService.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
