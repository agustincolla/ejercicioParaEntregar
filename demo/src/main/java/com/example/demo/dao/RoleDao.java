package com.example.demo.dao;

import java.util.UUID;
import com.example.demo.model.Role;

public interface RoleDao {
	int insertRole(UUID id,Role role);
	//add a role
	default int insertRole(Role role) {
		UUID id= UUID.randomUUID();
		return insertRole(id, role);
	}
}
