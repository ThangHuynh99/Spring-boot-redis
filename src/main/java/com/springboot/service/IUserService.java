package com.springboot.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.springboot.dto.UserDTO;
import com.springboot.entity.UserEntity;
import com.springboot.specification.UserSpecification;

public interface IUserService {
	List<UserDTO> findAll();
	UserDTO findOneById(Long id);
	UserDTO save(UserDTO userDTO);
	UserDTO update(UserDTO userDTO);
	void delete(Long id);
	List<UserDTO> findAll(String fullName);
}
