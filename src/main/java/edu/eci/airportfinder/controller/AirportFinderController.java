package edu.eci.airportfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.airportfinder.services.AirportFinderServices;

@RestController
@RequestMapping(value = "/airports")
public class AirportFinderController {
	
	@Autowired
	AirportFinderServices services;
	
	@RequestMapping(value = "/{name}", method=RequestMethod.GET)
	public ResponseEntity<?> getAiportsByName(@PathVariable String name){
		return new ResponseEntity<>(services.getAirportsByName(name),HttpStatus.ACCEPTED);
	}
}
