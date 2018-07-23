package com.reserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.Dao.GuestDao;
import com.reserve.bean.DiningReservation;
import com.reserve.bean.ResortReservation;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestDao guestDao;

	@Override
	public DiningReservation getBookingDetails(int guestId) {

		return guestDao.getBookingDetails(guestId);
	}

	@Override
	public ResortReservation getResortDetails(int guestId) {
		return guestDao.getResortDetails(guestId);
	}

}
