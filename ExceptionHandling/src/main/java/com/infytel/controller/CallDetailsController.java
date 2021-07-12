package com.infytel.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.infytel.dto.CallDetailsDTO;
import com.infytel.service.CallDetailsService;

@RestController
@RequestMapping("/calldetails")
public class CallDetailsController 
{
	@Autowired
	private CallDetailsService callDetailsService;
	
	//Fetching call details based on the request parameters being passed along with the URI
	@GetMapping(produces = "application/json")
	public List<CallDetailsDTO> callDetails(@RequestParam("calledBy") long calledBy, @RequestParam("calledOn") String calledOn)
	{
		return callDetailsService.fetchCallDetails(calledBy, LocalDate.parse(calledOn, DateTimeFormatter.ofPattern("MM-dd-yyyy")));   
	}
}
