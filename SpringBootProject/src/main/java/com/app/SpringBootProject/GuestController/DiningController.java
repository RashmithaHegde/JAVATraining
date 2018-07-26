package com.app.SpringBootProject.GuestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringBootProject.bean.Dining;
import com.app.SpringBootProject.service.IDiningService;

@RestController
public class DiningController {
	
	@Autowired
	IDiningService service;
	
	@PostMapping("/dining/register/{guestId}")
	public void Register(@PathVariable long guestId,@RequestBody Dining dining)
	{
		service.registerDining(dining,guestId);
	}
 
	@PutMapping("/dining/update/{dReservationNumber}")
	public void updateDining(@PathVariable long dReservationNumber  ,@RequestBody Dining dining)
	{
		Dining dining1=null;
		dining1= service.getDining(dReservationNumber);
		if(dining1!=null)
		{
			service.updateDining(dining, dReservationNumber);
		}
		else
			System.out.println("Invalid Update in process");
		
		
	}
	
	@GetMapping("/dining/get/{dReservationNumber}")
	public Dining getDining(@PathVariable long dReservationNumber )
	{
		Dining dining=service.getDining(dReservationNumber);
		return dining;
	}
	
	@GetMapping("/dining/getall/{guest_id}")
	public List<Dining> getAllResort(@PathVariable long guest_id )
	{
		List<Dining> dining=service.getAllDining(guest_id);
		return dining;
	}
	
	@PutMapping("/dining/cancel/{dReservationNumber}")
	public String cancelResort(@PathVariable long dReservationNumber)
	{
		long success=0;
		success=service.cancelDining(dReservationNumber);
		
		if(success>0)
		{
			return "Dining booking cancelled successfully.... The cancelled reservation id: "+dReservationNumber;
		}
		else
		return "Invalid Reservation Id. Please try again";
		
	}
	
	

}
