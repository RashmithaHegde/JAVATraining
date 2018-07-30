package com.app.SpringBootProject.bean;

import java.util.Date;

public class Resort {
	
	private long rReservationNumber;
	private long guestId;
	private String roomType ;
	private Date arrivalDate;
	private Date departureDate;
	private int noOfPeople;
	private String status;
	private Date createdDate;
	private Date updatedDate;
	
	public Resort() {
		
	}
	public Resort(long rReservationNumber, long guestId, String roomType, Date arrivalDate, Date departureDate,
			int noOfPeople, String status, Date createdDate, Date updatedDate) {
		super();
		this.rReservationNumber = rReservationNumber;
		this.guestId = guestId;
		this.roomType = roomType;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.noOfPeople = noOfPeople;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	
	public long getrReservationNumber() {
		return rReservationNumber;
	}
	public void setrReservationNumber(long rReservationNumber) {
		this.rReservationNumber = rReservationNumber;
	}
	public long getGuestId() {
		return guestId;
	}
	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date date) {
		this.arrivalDate = date;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public int getNoOfPeople() {
		return noOfPeople;
	}
	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Override
	public String toString() {
		return "Resort [rReservationNumber=" + rReservationNumber + ", guestId=" + guestId + ", roomType=" + roomType
				+ ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + ", noOfPeople=" + noOfPeople
				+ ", status=" + status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
