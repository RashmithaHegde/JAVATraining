package com.app.SpringBootProject.dao;

import java.util.List;

import com.app.SpringBootProject.bean.Resort;

public interface IResortDao {
	
	public Resort registerResort(Resort resort,long guestId);
	
	public long updateResort(Resort resort,long rReservationNumber);
	public Resort getResort(long rReservationNumber);
	public List<Resort> getAllResort(long guestId);
	public long cancelResort(long rReservationNumber);

}
