package com.hotelBooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelBooking.dto.BookingDTO;
import com.hotelBooking.dto.BookingResponseDto;
import com.hotelBooking.entity.Booking;
import com.hotelBooking.entity.Hotel;
import com.hotelBooking.entity.User;
import com.hotelBooking.repository.BookingRepository;
import com.hotelBooking.repository.HotelRepository;
import com.hotelBooking.repository.UserRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	HotelRepository hotelRepo;
	@Autowired
	UserRepository userRepo;

	public void bookHotel(BookingDTO bookingdto) {
		Booking booking = new Booking();
		Hotel hotel = hotelRepo.findById(bookingdto.getHotelId()).orElse(null);
		User user = userRepo.findById(bookingdto.getUserId()).orElse(null);

		booking.setUser(user);
		booking.setHotel(hotel);
		booking.setFromDate(bookingdto.getFromDate());
		booking.setToDate(bookingdto.getToDate());
		booking.setStatus("booked");
		booking.setTotalDays(bookingdto.getTotalDays());
		booking.setTotalAmount(bookingdto.getTotalAmount());

		bookingRepository.save(booking);
	}

	public List<BookingResponseDto> getBookingHistory(Long userID) {
		List<BookingResponseDto> dtoList = new ArrayList<>();
		User user = userRepo.findById(userID).orElse(null);

		List<Booking> bookingDetails = bookingRepository.findByUser(user);
		for (Booking booking : bookingDetails) {
			BookingResponseDto dto = new BookingResponseDto(booking);
			dtoList.add(dto);

		}

		return dtoList;
	}

	public List<Booking> getALlBooking() {
		List<Booking> list = bookingRepository.findAll();
		return list;
	}

	public Booking getBookByID(Long ID) {

		return bookingRepository.findById(ID).orElse(null);
	}

	public List<Booking> getbyDates(String fromDate, String toDate) {
		List<Booking> list = new ArrayList<>();

//		return bookingRepository.findByFromDateNotBetweenAndToDateNotBetween(fromDate, toDate, fromDate, toDate);
//	

//		return bookingRepository.findByToDateNotBetween(fromDate, toDate);
		return list;
	}
}
