package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.AuthenticationRequest;
import com.springboot.model.AuthenticationResponse;
import com.springboot.service.impl.MyUserDetailsService;
import com.springboot.utils.JwtUtil;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired 
	private JwtUtil jwtTokenUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenRequest.getUserName(), authenRequest.getPassWord()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenRequest.getUserName());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
