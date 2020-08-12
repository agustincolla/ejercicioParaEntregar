package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;

@RestController
public class RoleController {

	private final RoleService roleService;
    //roleController constructor
	@Autowired
	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}
	//add a role
	@PostMapping
	public void addRole(Role role) {
		roleService.addRole(role);
	}
}
