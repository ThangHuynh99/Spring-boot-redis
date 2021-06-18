package com.springboot.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
