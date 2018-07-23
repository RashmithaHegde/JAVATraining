package com.reserve.bean;

import java.util.Date;

public class ResortReservation {
	private int reservationNumber;
	private int guestId;
	private String roomType;
	private Date arrivalDate;
	private Date departureDate;
	private int noOfPeople;
	private String status;
	private Date createdDate;
	private Date updatedDate;
	public int getReservationNumber() {
		return reservationNumber;
	}
	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
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
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
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
		return "ResortReservation [reservationNumber=" + reservationNumber + ", guestId=" + guestId + ", roomType="
				+ roomType + ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + ", noOfPeople="
				+ noOfPeople + ", status=" + status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}



}
