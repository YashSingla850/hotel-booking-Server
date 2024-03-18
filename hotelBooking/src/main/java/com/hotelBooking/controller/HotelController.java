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

import com.hotelBooking.entity.Hotel;
import com.hotelBooking.service.HotelService;

@CrossOrigin
@RestController
@RequestMapping("/api/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelService;

	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> hotels = hotelService.getAllHotels();
		return ResponseEntity.ok(hotels);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getBookByID(@PathVariable("id") Long ID) {
		Hotel hotel = hotelService.getByID(ID);
		return ResponseEntity.ok(hotel);
	}

	@PostMapping()
	public ResponseEntity<Hotel> getBookByID(@RequestBody Hotel hotel) {
		return ResponseEntity.ok(hotelService.addHotel(hotel));

	}

	@GetMapping("/dateFilter")
	public ResponseEntity<List<Hotel>> getAllHotelsByDates(@RequestParam String fromDate, @RequestParam String toDate) {
		List<Hotel> hotels = hotelService.getHotelWithDates(fromDate, toDate);
		return ResponseEntity.ok(hotels);

	}
}