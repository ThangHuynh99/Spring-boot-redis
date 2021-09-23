package com.springboot.specification;

import org.springframework.data.jpa.domain.Specification;

import com.springboot.entity.UserEntity;

public final class UserSpecification  {
	public static Specification<UserEntity> likeFullName(String fullName) {
		return (root, query, cb) -> {
		if(fullName == null || fullName.trim().equals("")) {
			return cb.conjunction();
		} 
			return cb.like(root.get("fullName"), "%" + fullName + "%");
		};
	}
	
	public static Specification<UserEntity> equalEmail(String email) {
		return (root, query, cb) -> {
		if(email == null || email.trim().equals("")) {
			return cb.conjunction();
		} 
	
			return cb.like(root.get("email"), "%" + email + "%");
		};
	}

}
