package com.reserve.Dao;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.reserve.bean.Guest;
import com.reserve.mapper.GuestRowMapper;

@Transactional
@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	int id = 0;

	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	@Override
	public int addGuest(Guest guest) {
		int count = 0;

		try {
			count = jdbcTemplate.update(
					"insert into guest (guest_id,email,first_name,last_name,address,phone,password,created_date,updated_date) VALUES(?,?,?,?,?,?,?,?,?)",
					new Object[] { ++id, guest.getEmail(), guest.getFirstName(), guest.getLastName(),
							guest.getAddress(), guest.getPhone(), guest.getPassword(), sqlDate, sqlDate });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean validateGuest(String emailId, String password) {
		RowMapper<Guest> rowmapper = new GuestRowMapper();
		try {
			Guest guest = jdbcTemplate.queryForObject("SELECT * FROM guest WHERE email = ? AND password= ?",
					new Object[] { emailId, password }, rowmapper);
			int id = guest.getGuestId();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if (id != 0) {
			return true;
		}
		return false;
	}

}
