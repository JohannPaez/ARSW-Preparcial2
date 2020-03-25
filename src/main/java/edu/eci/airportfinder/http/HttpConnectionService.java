package edu.eci.airportfinder.http;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class HttpConnectionService {
	
	
	public String getAirportsByName(String name) {
		String Json = null;
		try {
			HttpResponse<String> response = Unirest.get("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=" + name)
					.header("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
					.header("x-rapidapi-key", "54276a88a3msh34d1a569336cf16p1e0818jsn40847117ffe2")
					.asString();
			Json = response.getBody();
			System.out.println(Json);
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Json;
	}
	

}
