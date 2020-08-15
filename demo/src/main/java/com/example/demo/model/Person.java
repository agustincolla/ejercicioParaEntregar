package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;


public class Person {

	private String email=new String();
	private String firstName=new String();
	private String lastName=new String();
	private List<String> roles=new ArrayList<>();
	
	//person constructor
	public Person(String email, String firstName, String lastName, List<String> roles) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
	}
	//getter email of person
	public String getEmail() {
		return email;
	}
	//setter email of person
	public void setEmail(String email) {
		this.email = email;
	}
	//getter first name of person
	public String getFirstName() {
		return firstName;
	}
	//setter first name of person
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	//getter last name of person 
	public String getLastName() {
		return lastName;
	}
	//setter last name of person
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//getter roles of person
	public List<String> getRoles() {
		return roles;
	}
	//setter role of person
	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
	}
	//add a role for a person
	public void addRol(String r) {
		this.getRoles().add(r);
	}
	
}
