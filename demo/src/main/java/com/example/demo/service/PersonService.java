package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Service
public class PersonService {

	private final PersonDao personDao;

	public PersonService(@Qualifier("firstPersonDao")PersonDao personDao) {
		super();
		this.personDao = personDao;
	}
	//add a person
	public int addPerson(Person person) {
		return personDao.insertPerson(person);
	}
	//return all person
	public List<Person> getAllPerson(){
		return personDao.selectAllPerson();
	}
	// return person by email
	public Optional<Person> getPersonByEmail(String email){
		return personDao.selectPersonByEmail(email);
	}
	//delete person by email
	public int deletePersonByEmail(String email) {
		return personDao.deletePersonByEmail(email);
	}
	//modify person by email
	public int upDatePersonByEmail(String email,Person person) {
		return personDao.upDatePersonByEmail(email, person);
	}
}
