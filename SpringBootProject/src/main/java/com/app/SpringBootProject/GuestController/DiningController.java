package com.app.SpringBootProject.GuestController;

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
	
	@PostMapping("/dining/register")
	public void Register(@RequestBody Dining dining)
	{
		service.registerDining(dining);
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
	

}
