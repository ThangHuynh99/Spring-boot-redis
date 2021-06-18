package com.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleEntity extends BaseEntity{
	
	@Enumerated(EnumType.STRING)
	@Column(name="roleName")
	private RoleName roleName;

	@ManyToMany(mappedBy = "roles")
	List<UserEntity> users = new ArrayList<UserEntity>();

	public RoleName getRoleName() {
		return roleName;
	}

	
	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
}
