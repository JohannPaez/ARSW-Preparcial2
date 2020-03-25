package edu.eci.airportfinder.cache;


import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import edu.eci.airportfinder.model.ContenidoJson;

@Component
public class AirportFinderCache {
	
	
	private ConcurrentHashMap<String, ContenidoJson> cacheByName = new ConcurrentHashMap<>();
	
	
	public boolean isThereCache(String name) {
		boolean isThereCache = false;
		if (cacheByName.get(name) != null && System.currentTimeMillis() - cacheByName.get(name).getTiempo() <= 1000 * 60 * 5) {
			isThereCache = true;
		}	
		return isThereCache;
	}
	
	public void saveCache(String name, String json) {
		ContenidoJson contenidoJson = new ContenidoJson(System.currentTimeMillis(), json);
		cacheByName.put(name, contenidoJson);
		System.out.println("GUARDO EN CACHE!");
	}
	
	public String getCache(String name) {
		return cacheByName.get(name).getJson();
	}

}
