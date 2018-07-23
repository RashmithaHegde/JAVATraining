package com.reserve.service;

import com.reserve.bean.DiningReservation;
import com.reserve.bean.ResortReservation;

public interface GuestService {
	
	public DiningReservation getBookingDetails(int guestId);
	public ResortReservation getResortDetails(int guestId);
}
