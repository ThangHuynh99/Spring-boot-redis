package com.springboot.reporsitory;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springboot.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity>{
	long countByUserName(String userName);
	UserEntity findOneByUserName(String userName);
	//UserEntity findByFullNameOrEmail(Specification<UserEntity> user);
}
