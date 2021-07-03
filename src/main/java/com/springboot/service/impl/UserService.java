package com.springboot.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.springboot.converter.UserConverter;
import com.springboot.dto.UserDTO;
import com.springboot.entity.RoleEntity;
import com.springboot.entity.RoleName;
import com.springboot.entity.UserEntity;
import com.springboot.reporsitory.RoleRepository;
import com.springboot.reporsitory.UserRepository;
import com.springboot.service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> userDTO= new ArrayList<>();
		for(UserEntity user: userRepository.findAll()) {
			userDTO.add(userConverter.toDTO(user));
		}
		return userDTO;
	}

	@Override
	public UserDTO findOneById(Long id) {
		return userConverter.toDTO(userRepository.getOne(id));
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		List<RoleEntity> roleEntity = roleRepository.findByRoleName(RoleName.ROLE_USER);
		UserEntity userEntity = userConverter.toEntity(userDTO);
		userEntity.setPassWord(BCrypt.hashpw(userEntity.getPassWord(), BCrypt.gensalt(12)));
		userEntity.setRoles(roleEntity);
		return userConverter.toDTO(userRepository.save(userEntity));
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		UserEntity oldUser = userRepository.getOne(userDTO.getId());
		oldUser.setEmail(userDTO.getEmail());
		oldUser.setFullName(userDTO.getFullName());
		return userConverter.toDTO(userRepository.save(oldUser));
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
