package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.demo.model.Role;

public interface RoleDao {
	
	//add a role
	int insertRole(UUID id,Role role);
	//add a role
	default int insertRole(Role role) {
		UUID id= UUID.randomUUID();
		return insertRole(id, role);
	}
	//return all roles
	List<Role> selectAllRole();
	//delete role
	int deleteRoleById(UUID id);
	//modify role
	int upDateRoleById(UUID id, Role role);
	//select a role by id
	Optional<Role> selectRoleById(UUID id);
}
