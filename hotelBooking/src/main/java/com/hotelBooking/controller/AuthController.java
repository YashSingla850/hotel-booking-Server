package com.hotelBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelBooking.dto.LoginCred;
import com.hotelBooking.entity.User;
import com.hotelBooking.httpResponse.LoginResponse;
import com.hotelBooking.httpResponse.RegisterResponse;
import com.hotelBooking.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginCred loginRequest) {
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();

		User user = userService.authenticateUser(username, password);
		if (user != null) {
			return ResponseEntity.ok(new LoginResponse("Login successful", user));
		} else {
			return ResponseEntity.ok(new LoginResponse("Invalid userName or Password"));
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody LoginCred registerRequest) {
		String username = registerRequest.getUsername();
		String password = registerRequest.getPassword();

		User existingUser = userService.registerUser(username, password);
		if (existingUser != null) {
			// Registration successful, return user details
			return ResponseEntity.ok(new RegisterResponse("Registration successful", existingUser));
		} else {
			// Username already exists
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
		}
	}
}
