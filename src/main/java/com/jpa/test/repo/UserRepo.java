package com.jpa.test.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.test.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findUserByEmail(String email);
	Optional<User> findUserByUsername(String username);
	
}