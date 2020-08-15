package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("firstPersonDao")
public class ImplementationPersonDao implements PersonDao{

	private List<Person> db= new ArrayList<Person>();
	@Override
	//add a person
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		List<String> aux=person.getRoles();
		db.add(new Person(person.getEmail(),person.getFirstName(),person.getLastName(),aux));
		return 1;
	}

	@Override
	//select all person
	public List<Person> selectAllPerson() {
		// TODO Auto-generated method stub
		return db;
	}

	@Override
	//delete a person by id
	public int deletePersonById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	//delete a person by email
	public int deletePersonByEmail(String email) {
		// TODO Auto-generated method stub
		Optional<Person> person=this.selectPersonByEmail(email);
		if (person.isEmpty()) {
			return 0;
		}
		else {
			db.remove(person.get());
			return 1;
		}
	}

	@Override
	//modify person by id
	public int upDatePersonById(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	//modify person by email
	public int upDatePersonByEmail(String email, Person person) {
		// TODO Auto-generated method stub
		return this.selectPersonByEmail(email).map(p ->{
			int indexToUpDate = db.indexOf(p);
			if(indexToUpDate >= 0){
				db.set(indexToUpDate,new Person(email,person.getFirstName(),person.getLastName(),person.getRoles()));
				return 1;
			}
			else {
				return 0;
			}
		}).orElse(0);
	}

	@Override
	//select person by id
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//select a person by email
	public Optional<Person> selectPersonByEmail(String email) {
		// TODO Auto-generated method stub
		return db.stream().filter(person -> person.getEmail().equals(email)).findFirst();
	}

}
