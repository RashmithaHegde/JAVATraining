package com.app.SpringBootProject.GuestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.service.IResortService;

@RestController

public class ResortController {
	
	@Autowired
	IResortService service;
	
	@PostMapping("/resort/register/{guest_id}")
	public String Register(@PathVariable long guest_id, @RequestBody Resort resort)
	{
		long status=0;
		
		status=service.registerResort(resort,guest_id);
		if(status>0)
		{
			return "Resort registration successful :) ";
		}
		return "Something went wrong..could not register..try again :(";
	}
	

	
 
	@PutMapping("/resort/update/{r_reservation_number}")
	public String updateResort(@PathVariable long r_reservation_number  ,@RequestBody Resort resort)
	{
		long status=0;
		Resort resort1=null;
		resort1= service.getResort(r_reservation_number);
		if(resort1!=null)
		{
			status=service.updateResort(resort,r_reservation_number);
			
		}
		if(status>0)
		{
			return "Updated successfully for reservation id :"+r_reservation_number;
		}
		return "Something went wrong..could not update..try again :(";
		
		
	}
	
	@GetMapping("/resort/get/{r_reservation_number}")
	public Resort getResort(@PathVariable long r_reservation_number )
	{
		Resort resort=service.getResort(r_reservation_number);
		return resort;
	}
	@GetMapping("/resort/getall/{guest_id}")
	public List<Resort> getAllResort(@PathVariable long guest_id )
	{
		List<Resort> resort=service.getAllResort(guest_id);
		return resort;
	}
	
	@PutMapping("/resort/cancel/{r_reservation_number}")
	public String cancelResort(@PathVariable long r_reservation_number)
	{
		long success=0;
		success=service.cancelResort(r_reservation_number);
		
		if(success>0)
		{
			return "Resort booking cancelled successfully with reservation id: "+r_reservation_number;
		}
		else
		return "Invalid Reservation Id. Please try again";
		
	}
	
}
