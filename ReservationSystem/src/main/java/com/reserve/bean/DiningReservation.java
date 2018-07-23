package com.reserve.bean;

import java.util.Date;

public class DiningReservation {
	private int diningReservationNum;
	private int guestId;
	private String diningType;
	private Date arrivalDate;
	private int noOfPeople;
	private String status;
	private Date createdDate;
	private Date updatedDate;
	public int getDiningReservationNum() {
		return diningReservationNum;
	}
	public void setDiningReservationNum(int diningReservationNum) {
		this.diningReservationNum = diningReservationNum;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
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
		return "DiningReservation [diningReservationNum=" + diningReservationNum + ", guestId=" + guestId
				+ ", diningType=" + diningType + ", arrivalDate=" + arrivalDate + ", noOfPeople=" + noOfPeople
				+ ", status=" + status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}


}
