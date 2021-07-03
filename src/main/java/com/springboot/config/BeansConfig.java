package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.converter.UserConverter;

import org.modelmapper.ModelMapper;

@Configuration
public class BeansConfig {
	
	@Bean(name="mapper")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean(name="userConverter")
	public UserConverter userConverter() {
		return new UserConverter();
	}
	
}
