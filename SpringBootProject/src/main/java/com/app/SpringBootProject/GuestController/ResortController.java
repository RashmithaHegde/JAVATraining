package com.app.SpringBootProject.GuestController;

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
	
	@PostMapping("/resort/register")
	public void Register(@RequestBody Resort resort)
	{
		service.registerResort(resort);
	}
	

	
 
	@PutMapping("/resort/update/{r_reservation_number}")
	public void updateResort(@PathVariable long r_reservation_number  ,@RequestBody Resort resort)
	{
		Resort resort1=null;
		resort1= service.getResort(r_reservation_number);
		if(resort1!=null)
		{
			service.updateResort(resort,r_reservation_number);
		}
		else
			System.out.println("Invalid Update in process");
		
		
	}
	
	@GetMapping("/resort/get/{r_reservation_number}")
	public Resort getResort(@PathVariable long r_reservation_number )
	{
		Resort resort=service.getResort(r_reservation_number);
		return resort;
	}
	
}
