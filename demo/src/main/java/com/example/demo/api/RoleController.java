package com.example.demo.api;

import java.util.ArrayList;
import java.util.UUID;
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
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;

@RequestMapping("api/v1/role")
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
	public void addRole(@Valid @NonNull @NotBlank @RequestBody Role role) {
		roleService.addRole(role);
	}
	//return all role
	@GetMapping
	public ArrayList<Role> getAllRole(){
		return roleService.getAllRole();
	}
	//get role by id
	@GetMapping(path="{roleId}")
	public Role getRoleById(@PathVariable("roleId") UUID id) {
		return roleService.getRoleByID(id).orElse(null);
	}
	//delete a role by id
	@DeleteMapping(path="{roleId}")
	public void deleteById(@PathVariable("roleId") UUID id) {
		roleService.deleteRoleById(id);
	}
	//modify a role by id
	@PutMapping(path="{roleId}")
	public void upDateRoleById(@PathVariable("roleId") UUID id,@Valid @NonNull @RequestBody Role role) {
		roleService.upDateRoleById(id, role);
	}
}
