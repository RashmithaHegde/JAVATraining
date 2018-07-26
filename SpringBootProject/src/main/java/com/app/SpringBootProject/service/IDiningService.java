package com.app.SpringBootProject.service;

import java.util.List;

import com.app.SpringBootProject.bean.Dining;

public interface IDiningService {
	
	public void registerDining(Dining dining,long guestId);
	
	public void updateDining(Dining dining,long dReservationNumber);
	public Dining getDining(long dReservationNumber);
	public List<Dining> getAllDining(long guest_id);
	public long cancelDining(long dReservationNumber);
}
