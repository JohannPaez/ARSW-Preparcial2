package edu.eci.airportfinder.http;

import org.springframework.stereotype.Component;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


@Component
public class HttpConnectionService {
	
	
	public String getAirportsByName(String name) {
		String Json = null;
		try {
			HttpResponse<String> response = Unirest.get("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=" + name)
					.header("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
					.header("x-rapidapi-key", "54276a88a3msh34d1a569336cf16p1e0818jsn40847117ffe2")
					.asString();
			Json = response.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Json;
	}
	
	public String getAllApi() {
		System.out.println("ENTRO ALL API");
		String Json = null;
		try {
			HttpResponse<String> response = Unirest.get("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=Berlin")
					.header("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
					.header("x-rapidapi-key", "54276a88a3msh34d1a569336cf16p1e0818jsn40847117ffe2")
					.asString();
			Json = response.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return Json;
		
	}
	
	public String getApiParcial(String name) {
		System.out.println("ENTRO PARCIAL");
		String Json = null;
		try {
			HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=Canada")
					.header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
					.header("x-rapidapi-key", "54276a88a3msh34d1a569336cf16p1e0818jsn40847117ffe2")
					.asString();
			Json = response.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return Json;
		
	}
	
	
	
}
