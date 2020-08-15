package com.example.demo.api;

import java.util.List;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

	private final PersonService personService;
	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
	//add a person
	@PostMapping
	public void addPerson(@Valid @NonNull @NotBlank @RequestBody Person person) {
		personService.addPerson(person);
	}
	//return all person
	@GetMapping
	public List<Person> getAllPerson(){
		return personService.getAllPerson();
	}
	//get person by email
	@GetMapping(path="{email}")
	public Person getPersonByEmail(@PathVariable("email") String email){
		return personService.getPersonByEmail(email).orElse(null);
	}	
	//delete a person by id
	@DeleteMapping(path="{email}")
	public void deletePersonByEmail(@PathVariable("email") String email) {
		personService.deletePersonByEmail(email);
	}
	//modify a person by email
	@PutMapping(path="{email}")
	public void upDatePersonByEmail(@PathVariable("email") String email,@Valid @NonNull @RequestBody Person person) {
		personService.upDatePersonByEmail(email, person);
	}
}
