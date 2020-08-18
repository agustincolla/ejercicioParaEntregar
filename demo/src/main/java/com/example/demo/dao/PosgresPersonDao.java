package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.Person;
import com.example.demo.model.Role;

public class PosgresPersonDao implements PersonDao{
	private final JdbcTemplate jdbcTemplate ;
	@Autowired
	public PosgresPersonDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	//add a person 
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		final String firstQuery="INSERT INTO personRole (personRoleId,personId,roleId,validPersonRole) VALUES((uuid_generate_v4(),?,?,0);";
		int sizeOfRole=person.getRoles().size();
		final PostgresRoleDao postgresRoleDao=new PostgresRoleDao(jdbcTemplate);
		for(int i= 0;i < sizeOfRole;i++) {
			Optional<Role> role=postgresRoleDao.selectRoleByName(person.getRoles().get(i));
			jdbcTemplate.update(firstQuery,id,role.get().getId());
		}
		final String secondQuery="INSERT INTO person (personId,personEmail,personFirstName,personLastName,validPerson) VALUES (?,?,?,?,0);";
		return jdbcTemplate.update(secondQuery,id,person.getEmail(),person.getFirstName(),person.getLastName());
	}

	@Override
	public List<Person> selectAllPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePersonById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePersonByEmail(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int upDatePersonById(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int upDatePersonByEmail(String email, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Person> selectPersonByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
