package com.cg.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.fms.dao.FlightDao;
import com.cg.fms.entities.Flight;
import com.cg.fms.services.FlightService;

@SpringBootTest
public class FlightsTests {

	@Autowired
	private FlightService fs;

	@MockBean
	private FlightDao fd;

	@Test
	public void createNewFlightTest() {
		Flight flight = new Flight(11, "jet", "super", 100);
		when(fd.save(flight)).thenReturn(flight);
		assertEquals(flight, fs.createNewFlight(flight));
	}
	@Test
	public void findAllFlightTest(){
		when(fd.findAll()).thenReturn(Stream.of(new Flight(11, "jet", "super", 100)).collect(Collectors.toList()));
		assertEquals(1,fs.viewFlights().size());}

}
