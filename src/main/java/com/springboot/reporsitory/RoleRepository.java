package com.springboot.reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.RoleEntity;
import com.springboot.entity.RoleName;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	List<RoleEntity> findByRoleName(RoleName roleName);
}
