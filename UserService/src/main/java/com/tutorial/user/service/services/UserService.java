package com.tutorial.user.service.services;

import java.util.List;

import com.tutorial.user.service.entities.Users;

public interface UserService {

	Users saveUser(Users user);
	List<Users> getAllUSers();
	Users getUserById(String id);
}
