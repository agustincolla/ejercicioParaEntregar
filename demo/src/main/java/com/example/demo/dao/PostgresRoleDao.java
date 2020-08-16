package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;

@Repository("postgres")
public class PostgresRoleDao implements RoleDao{

	private final JdbcTemplate jdbcTemplate;
	@Autowired
	public PostgresRoleDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertRole(UUID id, Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	//return all role
	public List<Role> selectAllRole() {
		// TODO Auto-generated method stub
		final String query="SELECT id , roleName FROM role";
		jdbcTemplate.query(query,(resultSet,i)->{
			UUID id=UUID.fromString(resultSet.getString("id"));
			String roleName=resultSet.getString("roleName");
			return new Role(id,roleName);
			});
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
