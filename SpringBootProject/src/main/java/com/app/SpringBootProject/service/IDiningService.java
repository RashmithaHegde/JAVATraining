package com.app.SpringBootProject.service;

import com.app.SpringBootProject.bean.Dining;

public interface IDiningService {
	
	public void registerDining(Dining dining);
	
	public void updateDining(Dining dining,long dReservationNumber);
	public Dining getDining(long dReservationNumber);
}
