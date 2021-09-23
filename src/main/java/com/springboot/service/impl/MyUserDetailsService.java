package com.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.entity.RoleEntity;
import com.springboot.entity.UserEntity;
import com.springboot.reporsitory.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		if(userEntity == null) {
			throw new UsernameNotFoundException("Username is not exist!");
		}
		
		//put thong tin vao trong security de duy tri thong tin khi user login vao he thong
		List<GrantedAuthority> authorities = new ArrayList<>();
		//tim duoc role thong qua @manytomany
		for(RoleEntity role: userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
		}
		return new User(userEntity.getUserName(), userEntity.getPassWord(), authorities);
	}
}
