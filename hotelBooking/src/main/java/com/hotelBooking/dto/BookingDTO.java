package com.hotelBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookingDTO {
	private Long userId;

	private Long hotelId;

	private String fromDate;

	private String toDate;

	private Long totalAmount;

	private Long totalDays;

	private String transctionID;

	private String status;
}
