package com.app.SpringBootProject.service;

import java.util.List;

import com.app.SpringBootProject.bean.Resort;

public interface IResortService {
	
	public Resort registerResort(Resort resort,long guestId);
	public long updateResort(Resort resort,long rReservationNumber);
	public List<Resort> getAllResort(long guestId);
	public Resort getResort(long rReservationNumber);
	public long cancelResort(long rReservationNumber);
}

