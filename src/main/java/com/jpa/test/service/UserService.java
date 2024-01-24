package com.jpa.test.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.model.User;
import com.jpa.test.repo.UserRepo;

@Service
public class UserService {
	
	private UserRepo userRepo;
	
	@Autowired
	public UserService (UserRepo userRepo) {
		this.userRepo=userRepo;
	}

	public List<User> getUsers() {
		return userRepo.findAll();
	}

	public void addNewUser(User user) {
			userRepo.save(user);		
	}

	public void deleteUser(Long userId) {
		boolean exists=userRepo.existsById(userId);
		if(!exists) {
			throw new IllegalStateException("student with id");			
		}
		else {
			userRepo.deleteById(userId);
		}		
	}

	public void updateUser(Long userId, String username, String name, String email) {
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			
		}
		else {
			throw new IllegalStateException("user id not found");
		}
	}

}
