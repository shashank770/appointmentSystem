package com.jpa.test.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.model.User;
import com.jpa.test.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService)
	{
		this.userService=userService;
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		System.out.println("All Users printed");
		return userService.getUsers();
	}
	
	@PostMapping("/postUser")
	public void registerNewUser(@RequestBody User user) {
		userService.addNewUser(user);
	}
	
	@DeleteMapping(path="/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
	}
	
	@PutMapping(path="/{userId}/{userUsername}")
	public void updateUser(
			@PathVariable("userId") Long userId,
			@PathVariable("userUsername") String username,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String email) {
		userService.updateUser(userId, username,  name, email);
	}

}
