package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.dao.RoleDao;
import com.example.demo.model.Role;

@Service
public class RoleService {
	
   private final RoleDao roleDao; 
   //roleServise constructor
   @Autowired
   public RoleService(@Qualifier("firstDao") RoleDao roleDao) {
	super();
	this.roleDao = roleDao;
   }
   //add a role
   public int addRole(Role role) {
	   return roleDao.insertRole(role);
   }
}
