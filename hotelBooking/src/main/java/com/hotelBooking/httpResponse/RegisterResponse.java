package com.hotelBooking.httpResponse;

import com.hotelBooking.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegisterResponse {
	private String message;
	private User user;
}
