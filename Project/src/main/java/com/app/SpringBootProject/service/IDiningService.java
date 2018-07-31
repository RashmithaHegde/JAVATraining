package com.app.SpringBootProject.service;

import java.util.List;

import com.app.SpringBootProject.bean.Dining;

public interface IDiningService {
	
	public Dining registerDining(Dining dining,long guestId);
	
	public long updateDining(Dining dining,long dReservationNumber);
	public Dining getDining(long dReservationNumber);
	public List<Dining> getAllDining(long guestId);
	public long cancelDining(long dReservationNumber);
}
