package com.app.SpringBootProject.dao;

import com.app.SpringBootProject.bean.Dining;


public interface IDiningDao {
	
	public void registerDining(Dining dining);
	
	public void updateDining(Dining dining,long dReservationNumber);
	public Dining getDining(long dReservationNumber);

}
