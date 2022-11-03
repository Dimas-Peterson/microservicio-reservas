package com.user.service.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.userEntity.User;
import com.user.service.userRepository.iUserRepository;

@Service
public class UserService {

	@Autowired
	private iUserRepository userRepository;

	// Find and list user
	public List<User> getAll() {
		return userRepository.findAll();
	}

	// Find user by Id
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	// Create new user
	public User save(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

	// Get reservation

	// Save reservation
}
