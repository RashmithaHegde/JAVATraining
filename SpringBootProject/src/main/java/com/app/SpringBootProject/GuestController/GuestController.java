package com.app.SpringBootProject.GuestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.service.IGuestService;


@RestController

public class GuestController {
	
	@Autowired
	IGuestService service;
	
	@PostMapping("/guest/register")
	public void Register(@RequestBody Guest guest)
	{
		service.registerGuest(guest);
	}
 
	@PutMapping("/guest/update/{guestId}")
	public void updateGuest(@PathVariable long guestId  ,@RequestBody Guest guest)
	{
		Guest guest1 = new Guest();
		
		guest1= service.getGuest(guestId);
		if(guest1!=null)
		{
			service.updateGuest(guest, guestId);
		}
		else
			System.out.println("id does not exits");
		
	}
	
	@GetMapping("/guest/get/{guestId}")
	public Guest getResort(@PathVariable long guestId )
	{
		Guest guest=service.getGuest(guestId);
		return guest;
	}
	
}
