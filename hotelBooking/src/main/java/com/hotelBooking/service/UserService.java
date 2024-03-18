package com.hotelBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelBooking.entity.User;
import com.hotelBooking.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User authenticateUser(String username, String password) {
		User user = userRepository.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	public User registerUser(String username, String password) {

		if (userRepository.findByUsername(username) != null) {
			return null;
		}

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userRepository.save(user);

		return user;
	}
}
