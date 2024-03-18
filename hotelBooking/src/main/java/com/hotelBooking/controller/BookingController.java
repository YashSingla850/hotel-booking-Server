package com.hotelBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelBooking.dto.BookingDTO;
import com.hotelBooking.dto.BookingResponseDto;
import com.hotelBooking.entity.Booking;
import com.hotelBooking.service.BookingService;

@CrossOrigin
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@PostMapping
	public ResponseEntity<?> bookHotel(@RequestBody BookingDTO booking) {
		bookingService.bookHotel(booking);
		return ResponseEntity.ok("Hotel booked successfully");
	}

	@GetMapping("/history/{userId}")
	public ResponseEntity<List<BookingResponseDto>> getBookingHistory(@PathVariable Long userId) {
		List<BookingResponseDto> bookingHistory = bookingService.getBookingHistory(userId);
		return ResponseEntity.ok(bookingHistory);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBookByID(@RequestParam Long ID) {
		Booking booking = bookingService.getBookByID(ID);
		return ResponseEntity.ok(booking);
	}
}
