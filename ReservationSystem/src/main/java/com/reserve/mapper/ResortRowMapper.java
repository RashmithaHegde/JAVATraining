package com.reserve.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.reserve.bean.ResortReservation;

public class ResortRowMapper implements RowMapper<ResortReservation>{

	@Override
	public ResortReservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ResortReservation resort = new ResortReservation();
		
		resort.setReservationNumber(rs.getInt("r_reservation_number"));
		resort.setGuestId(rs.getInt("guest_id"));
		resort.setRoomType(rs.getString("room_type"));
		resort.setArrivalDate(rs.getDate("arrival_date"));
		resort.setDepartureDate(rs.getDate("departure_date"));
		resort.setNoOfPeople(rs.getInt("no_of_people"));
		resort.setStatus(rs.getString("status"));
		resort.setCreatedDate(rs.getDate("created_date"));
		resort.setUpdatedDate(rs.getDate("updated_date"));
		
		return resort;
	}

}
