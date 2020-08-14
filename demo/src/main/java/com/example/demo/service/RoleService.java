package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
   public RoleService(@Qualifier("postgres") RoleDao roleDao) {
	super();
	this.roleDao = roleDao;
   }
   //add a role
   public int addRole(Role role) {
	   return roleDao.insertRole(role);
   }
   //return all roles
   public List<Role> getAllRole(){
	   return roleDao.selectAllRole();
   }
   //return role by id
   public Optional<Role> getRoleByID(UUID id){
	   return roleDao.selectRoleById(id);
   }
   //delete a role by id
   public int deleteRoleById(UUID id) {
	   return roleDao.deleteRoleById(id);
   }
   //modify a role
   public int upDateRoleById(UUID id , Role role) {
	   return roleDao.upDateRoleById(id, role);
   }
}
