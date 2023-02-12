package com.cg.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.fms.dao.BookingDao;
import com.cg.fms.entities.Booking;
import com.cg.fms.services.BookingService;


@SpringBootTest
public class BookingsTests {

	@Autowired
	private BookingService booking;

	@MockBean
	private BookingDao bdao;

	@Test
	public void createNewBookingTest() {
		Booking bs = new Booking(123, 1);
		when(bdao.save(bs)).thenReturn(bs);
		assertEquals(bs, booking.createNewBooking(bs));
	}

	@Test
	public void findAllTest(){
		when(bdao.findAll()).thenReturn(Stream.of(new Booking(123,1)).collect(Collectors.toList()));
		assertEquals(1,booking.viewAllBooking().size());}

}
