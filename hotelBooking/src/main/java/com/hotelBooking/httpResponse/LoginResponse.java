package com.hotelBooking.httpResponse;

import com.hotelBooking.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginResponse {
	private String message;
	private User user;

	public LoginResponse(String message) {
		this.message = message;
	}
}
