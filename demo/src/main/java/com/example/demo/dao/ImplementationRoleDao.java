package com.example.demo.dao;

import java.util.ArrayList;
import java.util.UUID;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;

@Repository("firstDao")
public class ImplementationRoleDao implements RoleDao{
    
	private ArrayList<Role> db= new ArrayList<>();
	@Override
	//add a role
	public int insertRole(UUID id, Role role) {
		db.add(new Role(id,role.getRoleName()));
		return 1;
	}

}
