package com.cg.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.fms.dao.ScheduledFlightDao;
import com.cg.fms.entities.ScheduledFlight;
import com.cg.fms.services.ScheduledFlightService;

@SpringBootTest
public class SechduledFlightTests {

	@Autowired
	private ScheduledFlightService sfs;

	@MockBean
	private ScheduledFlightDao sfd;

	@Test
	public void createScheduledFlightTest() {
		ScheduledFlight sf = new ScheduledFlight(1, 60);
		when(sfd.save(sf)).thenReturn(sf);
		assertEquals(sf, sfs.createScheduledFlight(sf));

	}
	@Test
	public void findAllScheduledFlightTest(){
		when(sfd.findAll()).thenReturn(Stream.of(new ScheduledFlight(1, 60)).collect(Collectors.toList()));
		assertEquals(1,sfs.viewScheduledFlights().size());}

}
