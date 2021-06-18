package com.springboot.service;

import java.util.List;

import com.springboot.dto.UserDTO;

public interface IUserService {
	List<UserDTO> findAll();
	UserDTO findOneById(Long id);
	UserDTO save(UserDTO userDTO);
	UserDTO update(UserDTO userDTO);
	void delete(Long id);
}
