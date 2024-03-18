package com.hotelBooking.dto;

import com.hotelBooking.entity.Booking;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingResponseDto {

	private String hotelName;

	private String fromDate;

	private String toDate;

	private Long totalAmount;

	private Long totalDays;

	private String status;

	public BookingResponseDto(Booking booking) {
		this.hotelName = booking.getHotel().getName();
		this.fromDate = booking.getFromDate();
		this.toDate = booking.getToDate();
		this.totalAmount = booking.getTotalAmount();
		this.totalDays = booking.getTotalDays();
		this.status = booking.getStatus();
	}

}
