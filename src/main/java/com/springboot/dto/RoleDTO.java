package com.springboot.dto;

import java.util.List;

import com.springboot.entity.RoleName;

public class RoleDTO extends AbstractDTO<RoleDTO>{
	private RoleName roleName;
	private List<UserDTO> userDTO;
	
	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	public List<UserDTO> getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(List<UserDTO> userDTO) {
		this.userDTO = userDTO;
	}
	
}
