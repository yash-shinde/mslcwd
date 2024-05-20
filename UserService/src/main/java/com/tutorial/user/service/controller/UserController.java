package com.tutorial.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.user.service.entities.Users;
import com.tutorial.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired private UserService userServ;
	
	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody Users user){
		Users user1 = userServ.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getSingleUser(@PathVariable String id){
		
		Users user = userServ.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users> all_users = userServ.getAllUSers();
		return ResponseEntity.ok(all_users);
	}
}
