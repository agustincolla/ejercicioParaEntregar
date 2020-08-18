package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;

@Repository("postgresRole")
public class PostgresRoleDao implements RoleDao{

	private final JdbcTemplate jdbcTemplate;
	@Autowired
	public PostgresRoleDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	//insert a role
	public int insertRole(UUID id, Role role) {
		// TODO Auto-generated method stub
		final String query="INSERT INTO role (roleId,roleName,validRole) VALUES (?,?,0);";
		return jdbcTemplate.update(query,id,role.getRoleName());
	}

	@Override
	//return all role
	public List<Role> selectAllRole() {
		// TODO Auto-generated method stub
		final String query="SELECT roleId , roleName FROM role WHERE validRole = 0;";
		return jdbcTemplate.query(query,(resultSet,i)->{
			UUID id=UUID.fromString(resultSet.getString("roleId"));
			String roleName=resultSet.getString("roleName");
			return new Role(id,roleName);
			});	 
	}

	@Override
	//delete a role by id
	public int deleteRoleById(UUID id) {
		// TODO Auto-generated method stub
		final String query="UPDATE role  SET validRole = 1 WHERE validRole = 0 AND roleId = ?;";
		return jdbcTemplate.update(query,id);
	}

	@Override
	//modify role by id
	public int upDateRoleById(UUID id, Role role) {
		// TODO Auto-generated method stub
		final String query="UPDATE role  SET roleName=? WHERE validRole = 0 AND roleId = ?;";
		return jdbcTemplate.update(query,role.getRoleName(),id);
	}

	@Override
	//return role by id
	public Optional<Role> selectRoleById(UUID id) {
		// TODO Auto-generated method stub
		final String query="SELECT roleId , roleName FROM role WHERE validRole = 0 AND roleId = ?;";
		Role role=jdbcTemplate.queryForObject(query,new Object[] {id},(resultSet,i)->{
			UUID idOfRole=UUID.fromString(resultSet.getString("roleId"));
			String roleName=resultSet.getString("roleName");
			return new Role(idOfRole,roleName);
			});	 
		return Optional.ofNullable(role);
	}
	//return role by name
	public Optional<Role> selectRoleByName(String name){
		final String query="SELECT roleId , roleName FROM role WHERE validRole = 0 AND roleName = ?;";
		Role role=jdbcTemplate.queryForObject(query,new Object[] {name},(resultSet,i)->{
			UUID idOfRole=UUID.fromString(resultSet.getString("roleId"));
			String roleName=resultSet.getString("roleName");
			return new Role(idOfRole,roleName);
			});	 
		return Optional.ofNullable(role);
	}

}
