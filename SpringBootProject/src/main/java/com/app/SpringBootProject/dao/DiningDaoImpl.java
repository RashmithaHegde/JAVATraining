package com.app.SpringBootProject.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.SpringBootProject.bean.Dining;
import com.app.SpringBootProject.bean.DiningRowMapper;

@Transactional
@Repository
public class DiningDaoImpl implements IDiningDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	Date date=new Date();
	//java.sql.Date sqlDate = new  java.sql.Date(date.getTime());
	
	

	@Override
	public void registerDining(Dining dining,long guestId) {
		
		String status="booked";
		
		String query= "INSERT INTO dining(guest_id,dining_type,arrival_date,no_of_people,created_date,updated_date) VALUES (?,?,?,?,?,?)";
		
		long success=jdbcTemplate.update(query,guestId,dining.getDiningType(),dining.getArrivalDate(),dining.getNoOfPeople(),date,date);
		
		if(success==1)
		{
			String query1= "UPDATE dining SET status=? ";

			jdbcTemplate.update(query1,status);

		}
		else
			System.out.println("Insertion failed, SOMETHING WENT WRONG . . .!!!");
		
		
	}

	@Override
	public void updateDining(Dining dining, long dReservationNumber) {
		
		
		String query= "UPDATE dining SET dining_type=?, arrival_date=?,no_of_people=?,updated_date=? "
				+ "WHERE d_reservation_number=?";
		
		jdbcTemplate.update(query,dining.getDiningType(),dining.getArrivalDate(),dining.getNoOfPeople(),
				date,dReservationNumber);
				
		
		
	}

	@Override
	public Dining getDining(long dReservationNumber) {
	
		Dining dining = jdbcTemplate.queryForObject("SELECT * FROM dining WHERE d_reservation_number = ?",
			     new Object[] { dReservationNumber }, new DiningRowMapper());
		return dining;
	}

	@Override
	public List<Dining> getAllDining(long guest_id) {
		String query="SELECT * FROM DINING WHERE guest_id="+guest_id+"";
		List<Dining> dining=jdbcTemplate.query(query,new DiningRowMapper());
		return dining;
	
	}

	@Override
	public long cancelDining(long dReservationNumber) {
		String status = "cancelled";
		long success;
		
		String query1 = "UPDATE dining SET status=? where d_reservation_number="+dReservationNumber+"";
		
		try {
			
			success = jdbcTemplate.update(query1,status);
			
		} catch (DataAccessException e) {
			return 0;
		}
		if(success==1)
		{
			return dReservationNumber;
		}
		return dReservationNumber;
		
	}
	
	

}
