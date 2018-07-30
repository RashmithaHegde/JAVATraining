package com.app.SpringBootProject.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GuestRowMapper implements RowMapper<Guest>  {

	@Override
	public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
		Guest guest = new Guest();
		guest.setguestId(rs.getLong("guest_id"));
		guest.setEmail(rs.getString("email"));
		guest.setFirstName(rs.getString("first_name"));
		guest.setLastName(rs.getString("last_name"));
		guest.setAddress(rs.getString("address"));
		guest.setPhone(rs.getString("phone"));
		guest.setPassword(rs.getString("password"));
		guest.setCreatedDate(rs.getDate("created_date"));
		guest.setupdatedDate(rs.getDate("updated_date"));
		
		return guest;
	}

}
