package com.reserve.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reserve.bean.DiningReservation;
import com.reserve.bean.ResortReservation;
import com.reserve.bean.ResponseBooking;
import com.reserve.service.GuestService;

@RestController
@RequestMapping("/response")
public class GuestController {

	@Autowired
	private GuestService guestService;
	
	@GetMapping("/bookings/{id}")
	public ResponseBooking getTopics(@PathVariable("id") int guestId) {
		
		ResponseBooking booking = new ResponseBooking();
		
		List<DiningReservation> diningReservations = new ArrayList<>();	
		DiningReservation diningReservation = guestService.getBookingDetails(guestId);
		
		List<ResortReservation> resortReservations = new ArrayList<>();	
		ResortReservation resortReservation1 = guestService.getResortDetails(guestId);
		
		
		diningReservations.add(diningReservation);
		resortReservations.add(resortReservation1);
		
		booking.setDiningReservations(diningReservations);
		booking.setResortReservations(resortReservations);
		
		return booking;
		
	}
	
}
