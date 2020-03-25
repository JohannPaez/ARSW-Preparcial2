package edu.eci.airportfinder.services;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;
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
			System.out.println("Consumio CACHE!");
		} else {
			airports = serviceHttp.getAirportsByName(name);
			serviceCache.saveCache(name, airports);
		}
		
		return airports;
	}
	
	public String getAllApi() {
		return serviceHttp.getAllApi();
	}
	
	public String getApiParcial(String name) {
		String jsonParcial = serviceHttp.getApiParcial(name);
		JSONObject jo = new JSONObject(jsonParcial);
		JSONObject data = jo.getJSONObject("data");
		JSONArray covid19Stats = jo.getJSONObject("data").getJSONArray("covid19Stats");
		
		System.out.println("JSON COMPLEJO -------------------------------------------------------------------------- \n \n" + 
							jo +
							"\n \n DATA JSON -------------------------------------------------------------------------- \n \n" + 
							data + 
							"\n \n covid19Stats JSON -------------------------------------------------------------------------- \n \\n" + 
							covid19Stats + " \n \n \n");
		JSONArray res = new JSONArray();
		for (int i = 0; i < covid19Stats.length(); i++) {
			JSONObject ciclo = new JSONObject(covid19Stats.get(i).toString());
			HashMap<String, String> cicloJ = new HashMap(ciclo.toMap());
			System.out.println("CICLO " + ciclo);
			if ((int) ciclo.get("deaths") == 1) {
				res.put(cicloJ);
			}
		}
		System.out.println("SOLO LOS QUE TIENEN 0 MUERTES -------------------------------------------------------------------- \n \n " +
							res);
		return res.toString();
	}

}
