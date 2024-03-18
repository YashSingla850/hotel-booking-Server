package com.hotelBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelBooking.entity.Booking;
import com.hotelBooking.entity.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	List<Booking> findByUser(User user);

//	List<Booking> findByFromDateNotBetweenAndToDateNotBetween(String fromDateStart, String fromDateEnd,
//			String toDateStart, String toDateEnd);

//	List<Booking> findByToDateNotBetween(String toDateStart, String toDateEnd);
}
