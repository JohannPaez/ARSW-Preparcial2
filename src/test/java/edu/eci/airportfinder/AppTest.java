package edu.eci.airportfinder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import edu.eci.airportfinder.http.HttpConnectionService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AppTest {
	@Autowired
	private MockMvc mock;
	@Autowired
	private HttpConnectionService conexion;
	
	
	/**
	 * Revisa que al consultar los aeropuertos de la ciudad de Londres debería mandar un status 
	 */
	@Test
	public void shouldBeGetAirportsOfLondon() {
		try {
			mock.perform(get("/airports/London")).andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Revisa las propiedades de la conexion que hacemos para consumir el Api y revisamos que nos la información deseada verificando la longitud dada.
	 */
	@Test
	public void shouldBeLondonProperties() {
		String airports = conexion.getAirportsByName("London");
		assertTrue(airports != null && airports.length() > 10);
	}

}
