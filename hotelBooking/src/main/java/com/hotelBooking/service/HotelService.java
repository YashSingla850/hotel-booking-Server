package com.hotelBooking.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelBooking.entity.Booking;
import com.hotelBooking.entity.Hotel;
import com.hotelBooking.repository.HotelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HotelService {

	HotelRepository hotelRepository;
	BookingService bookingService;

	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	public Hotel getByID(Long ID) {
		return hotelRepository.findById(ID).orElseThrow(null);
	}

	public Hotel addHotel(Hotel hotel) {

		return hotelRepository.save(hotel);

	}

	public List<Hotel> getHotelWithDates(String fromDate, String toDate) {
		List<Hotel> hotelList = new ArrayList<>();
		List<Booking> bookingList = bookingService.getbyDates(fromDate, toDate);
		HashSet<Long> set = new HashSet<>();
		for (Booking booking : bookingList) {
			set.add(booking.getHotel().getId());
		}
		List<Hotel> allHotelList = getAllHotels();
		for (Hotel hotel : allHotelList) {
			if (!set.contains(hotel.getId())) {
				hotelList.add(hotel);
			}
		}
		return hotelList;
	}
}