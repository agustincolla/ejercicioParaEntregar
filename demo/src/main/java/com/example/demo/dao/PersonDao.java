package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDao {

	//add a person
		int insertPerson(UUID id,Person person);
		//add a person
		default int insertPerson(Person person) {
			UUID id= UUID.randomUUID();
			return insertPerson(id, person);
		}
		//return all persons
		List<Person> selectAllPerson();
		//delete person by id
		int deletePersonById(UUID id);
		//delete person by email
		int deletePersonByEmail(String email);
		//modify person by id
		int upDatePersonById(UUID id, Person person);
		//modify person by email
		int upDatePersonByEmail(String email,Person person);
		//select a person by id
		Optional<Person> selectPersonById(UUID id);
		//select a person by email
		Optional<Person> selectPersonByEmail(String email);
}
