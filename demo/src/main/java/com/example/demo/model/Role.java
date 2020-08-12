package com.example.demo.model;

import java.util.UUID;

public class Role {
  private UUID id;
  private String roleName=new String();

  //role constructor
  public Role(UUID id, String roleName) {
	super();
	this.id = id;
	this.roleName = roleName;
  }
//getter id of role
  public UUID getId() {
	return id;
  }
  //setter id of role
  public void setId(UUID id) {
	this.id = id;
  }
  //getter role name 
  public String getRoleName() {
	return roleName;
  }
  //setter role name
  public void setRoleName(String roleName) {
	this.roleName = roleName;
  }
}
