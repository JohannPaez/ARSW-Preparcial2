package edu.eci.airportfinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.airportfinder.cache.AirportFinderCache;
import edu.eci.airportfinder.http.HttpConnectionService;

@Service
public class AirportFinderServices {
	
	@Autowired
	HttpConnectionService serviceHttp;
	@Autowired
	AirportFinderCache serviceCache;
	
	public String getAirportsByName(String name) {
		String airports = null;
		
		if (serviceCache.isThereCache(name)) {
			airports = serviceCache.getCache(name);
		} else {
			airports = serviceHttp.getAirportsByName(name);
			serviceCache.saveCache(name, airports);
			System.out.println("Consumio Api");
		}
		
		return airports;
	}

}
