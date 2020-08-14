package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;

@Repository("postgres")
public class PostgresRoleDao implements RoleDao{

	@Override
	public int insertRole(UUID id, Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> selectAllRole() {
		// TODO Auto-generated method stub
		return  List.of(new Role(UUID.randomUUID(),"FROM POSTGRES DB"));
	}

	@Override
	public int deleteRoleById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int upDateRoleById(UUID id, Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Role> selectRoleById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
