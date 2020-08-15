package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;

@Repository("firstDao")
public class ImplementationRoleDao implements RoleDao{
    
	private List<Role> db= new ArrayList<>();
	@Override
	//add a role
	public int insertRole(UUID id, Role role) {
		db.add(new Role(id,role.getRoleName()));
		return 1;
	}
	@Override
	//select all roles
	public List<Role> selectAllRole() {
		// TODO Auto-generated method stub
		return db;
	}
	@Override
	//delete a role by id
	public int deleteRoleById(UUID id) {
		// TODO Auto-generated method stub
		Optional<Role> role=this.selectRoleById(id);
		if (role.isEmpty()) {
			return 0;
		}
		else {
			db.remove(role.get());
			return 1;
		}
		
	}
	@Override
	//modify a role by id
	public int upDateRoleById(UUID id, Role role) {
		// TODO Auto-generated method stub
		return this.selectRoleById(id).map(r ->{
			int indexToUpDate = db.indexOf(r);
			if(indexToUpDate >= 0){
				db.set(indexToUpDate,new Role(id,role.getRoleName()));
				return 1;
			}
			else {
				return 0;
			}
		}).orElse(0);
	}
	@Override
	//select role by id
	public Optional<Role> selectRoleById(UUID id) {
		// TODO Auto-generated method stub
		return db.stream().filter(role -> role.getId().equals(id)).findFirst();
	}

}
