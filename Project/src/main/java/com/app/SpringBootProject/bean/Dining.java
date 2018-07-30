package com.app.SpringBootProject.bean;

import java.util.Date;

public class Dining {
	
	private long dReservationNumber;
	private long guestId;
	private String diningType ;
	private Date arrivalDate;
	private int noOfPeople;
	private String status;
	private Date createdDate;
	private Date updatedDate;
	
	public Dining() {
	
	}
	public Dining(long dReservationNumber, long guestId, String diningType, Date arrivalDate, int noOfPeople,
			String status, Date createdDate, Date updatedDate) {
		super();
		this.dReservationNumber = dReservationNumber;
		this.guestId = guestId;
		this.diningType = diningType;
		this.arrivalDate = arrivalDate;
		this.noOfPeople = noOfPeople;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public long getdReservationNumber() {
		return dReservationNumber;
	}
	public void setdReservationNumber(long dReservationNumber) {
		this.dReservationNumber = dReservationNumber;
	}
	public long getGuestId() {
		return guestId;
	}
	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}
	public String getDiningType() {
		return diningType;
	}
	public void setDiningType(String diningType) {
		this.diningType = diningType;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
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
		return "Dining [dReservationNumber=" + dReservationNumber + ", guestId=" + guestId + ", diningType="
				+ diningType + ", arrivalDate=" + arrivalDate + ", noOfPeople=" + noOfPeople + ", status=" + status
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
	
}
