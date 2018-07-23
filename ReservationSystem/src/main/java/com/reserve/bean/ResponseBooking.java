package com.reserve.bean;

import java.util.List;

public class ResponseBooking {

	private int guestId;
	private List<DiningReservation> diningReservations;
	private List<ResortReservation> resortReservations;

	public ResponseBooking() {
		super();
	}

	public ResponseBooking(int guestId, List<DiningReservation> diningReservations,
			List<ResortReservation> resortReservation) {
		super();
		this.guestId = guestId;
		this.diningReservations = diningReservations;
		this.resortReservations = resortReservation;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public List<DiningReservation> getDiningReservations() {
		return diningReservations;
	}

	public void setDiningReservations(List<DiningReservation> diningReservations) {
		this.diningReservations = diningReservations;
	}

	public List<ResortReservation> getResortReservation() {
		return resortReservations;
	}

	public void setResortReservations(List<ResortReservation> resortReservation) {
		this.resortReservations = resortReservation;
	}

	@Override
	public String toString() {
		return "ResponseBooking [guestId=" + guestId + ", diningReservations=" + diningReservations
				+ ", resortReservation=" + resortReservations + "]";
	}

}
