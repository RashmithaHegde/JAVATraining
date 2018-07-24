package com.reserve.Dao;

import com.reserve.bean.DiningReservation;
import com.reserve.bean.ResortReservation;

public interface GuestDao {

	public DiningReservation getBookingDetails(int guestId);

	public ResortReservation getResortDetails(int guestId);

	public DiningReservation cancelDining(int diningReservationNum);

	public ResortReservation cancelResort(int resortReservationNum);

}
