package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;
import com.example.demo.model.Role;
@Repository("postgresPersonDao")
public class PostgresPersonDao implements PersonDao{
	private final JdbcTemplate jdbcTemplate ;
	@Autowired
	public PostgresPersonDao(JdbcTemplate jdbcTemplate) {
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
	//return all person
	public List<Person> selectAllPerson() {
		// TODO Auto-generated method stub
		final String query="SELECT personId ,personEmail ,personFirstName ,personLastName FROM person WHERE validPerson = 0;";
		return (List<Person>) jdbcTemplate.queryForObject(query,(resultSet,i)->{
			UUID idOfPerson=UUID.fromString(resultSet.getString("personId"));
			String personEmail=resultSet.getString("personEmail");
			String personFirstName=resultSet.getString("personFirstName");
			String personLastName=resultSet.getString("personLastName");
			List<String> listOfRole=new ArrayList<String>();
			List<String>listOfId=new ArrayList<String>();
			final String auxQuery="SELECT roleId FROM personRole WHERE validPersonRole =0 AND personId = ?";
			listOfId=  (List<String>) jdbcTemplate.queryForObject(auxQuery, new Object[] {idOfPerson},(resultSet2,j)->{
				List<String> aux=new ArrayList<String>();
				aux.add(resultSet2.getString("roleId"));
				return aux;
			});
			final PostgresRoleDao postgresRoleDao=new PostgresRoleDao(jdbcTemplate);
			for(int k=0;k<listOfId.size();k++) {
				listOfRole.add(postgresRoleDao.selectRoleById(UUID.fromString(listOfId.get(k))).get().getRoleName());
			}
			Person auxPerson=new Person(personEmail,personFirstName,personLastName,listOfRole);
			auxPerson.setId(idOfPerson);
			return auxPerson;
			});
	}

	@Override
	//delete a person by id
	public int deletePersonById(UUID id) {
		// TODO Auto-generated method stub
		final String firstQuery="UPDATE personRole  SET validPersonRole = 1 WHERE validPerson = 0 AND personId = ? AND roleId = ?;";
		Optional<Person> person=this.selectPersonById(id);
		int sizeOfRole=person.get().getRoles().size();
		final PostgresRoleDao postgresRoleDao=new PostgresRoleDao(jdbcTemplate);
		for(int i= 0;i < sizeOfRole;i++) {
			Optional<Role> role=postgresRoleDao.selectRoleByName(person.get().getRoles().get(i));
			jdbcTemplate.update(firstQuery,id,role.get().getId());
		}
		final String secondQuery="UPDATE person  SET validPerson = 1 WHERE validPerson = 0 AND personId = ?;";
		return jdbcTemplate.update(secondQuery,id);
	}

	@Override
	//delete person by email
	public int deletePersonByEmail(String email) {
		// TODO Auto-generated method stub
		final String firstQuery="UPDATE personRole  SET validPersonRole = 1 WHERE validPerson = 0 AND personId = ? AND roleId = ?;";
		Optional<Person> person=this.selectPersonByEmail(email);
		UUID personId=person.get().getID();
		int sizeOfRole=person.get().getRoles().size();
		final PostgresRoleDao postgresRoleDao=new PostgresRoleDao(jdbcTemplate);
		for(int i= 0;i < sizeOfRole;i++) {
			Optional<Role> role=postgresRoleDao.selectRoleByName(person.get().getRoles().get(i));
			jdbcTemplate.update(firstQuery,personId,role.get().getId());
		}
		final String secondQuery="UPDATE person  SET validPerson = 1 WHERE validPerson = 0 AND personEmail = ?;";
		return jdbcTemplate.update(secondQuery,email);
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
	//select a person by id
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		final String query="SELECT personId ,personEmail ,personFirstName ,personLastName FROM person WHERE validPerson = 0 AND personId = ?;";
		Person person=jdbcTemplate.queryForObject(query,new Object[] {id},(resultSet,i)->{
			UUID idOfPerson=UUID.fromString(resultSet.getString("personId"));
			String personEmail=resultSet.getString("personEmail");
			String personFirstName=resultSet.getString("personFirstName");
			String personLastName=resultSet.getString("personLastName");
			List<String> listOfRole=new ArrayList<String>();
			List<UUID>listOfId=new ArrayList<UUID>();
			final String auxQuery="SELECT roleId FROM personRole WHERE validPersonRole =0 AND personId = ?";
			listOfId=(List<UUID>) jdbcTemplate.queryForObject(auxQuery, new Object[] {id},(resultSet2,j)->{
				List<UUID>aux=new ArrayList<UUID>();
				aux.add(UUID.fromString(resultSet.getString("roleId")));
				return aux;
			});
			final PostgresRoleDao postgresRoleDao=new PostgresRoleDao(jdbcTemplate);
			for(int k=0;k<listOfId.size();k++) {
				listOfRole.add(postgresRoleDao.selectRoleById(listOfId.get(k)).get().getRoleName());
			}
			Person auxPerson=new Person(personEmail,personFirstName,personLastName,listOfRole);
			auxPerson.setId(idOfPerson);
			return auxPerson;
			});	 
		return Optional.ofNullable(person);
	}

	@Override
	//select a person by email
	public Optional<Person> selectPersonByEmail(String email) {
		// TODO Auto-generated method stub
		final String query="SELECT personId ,personEmail ,personFirstName ,personLastName FROM person WHERE validPerson = 0 AND personEmail = ?;";
		Person person=jdbcTemplate.queryForObject(query,new Object[] {email},(resultSet,i)->{
			UUID idOfPerson=UUID.fromString(resultSet.getString("personId"));
			String personEmail=resultSet.getString("personEmail");
			String personFirstName=resultSet.getString("personFirstName");
			String personLastName=resultSet.getString("personLastName");
			List<String> listOfRole=new ArrayList<String>();
			List<UUID>listOfId=new ArrayList<UUID>();
			final String auxQuery="SELECT roleId FROM personRole WHERE validPersonRole =0 AND personId = ?";
			listOfId=(List<UUID>) jdbcTemplate.queryForObject(auxQuery, new Object[] {idOfPerson},(resultSet2,j)->{
				List<UUID>aux=new ArrayList<UUID>();
				aux.add(UUID.fromString(resultSet.getString("roleId")));
				return aux;
			});
			final PostgresRoleDao postgresRoleDao=new PostgresRoleDao(jdbcTemplate);
			for(int k=0;k<listOfId.size();k++) {
				listOfRole.add(postgresRoleDao.selectRoleById(listOfId.get(k)).get().getRoleName());
			}
			Person auxPerson=new Person(personEmail,personFirstName,personLastName,listOfRole);
			auxPerson.setId(idOfPerson);
			return auxPerson;
			});	 
		return Optional.ofNullable(person);
	}

}
