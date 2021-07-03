package com.springboot.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.dto.UserDTO;
import com.springboot.entity.UserEntity;

public class UserConverter {
	@Autowired
	private ModelMapper mapper;
	
	public UserDTO toDTO(UserEntity userEntity) {
		UserDTO dto = mapper.map(userEntity, UserDTO.class);
		return dto;
	}
	
	public UserEntity toEntity(UserDTO userDTO) {
		UserEntity entity = mapper.map(userDTO, UserEntity.class);
		return entity;
	}
}
