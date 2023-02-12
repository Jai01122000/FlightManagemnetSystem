package com.cg.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.fms.dao.ScheduleDao;
import com.cg.fms.entities.Schedule;
import com.cg.fms.services.ScheduleService;

@SpringBootTest
public class ScheduleTests {

	@Autowired
	private ScheduleService schedule;

	@MockBean
	private ScheduleDao dao;

	@Test
	public void createScheduleTest() {
		Schedule scd = new Schedule(1, "Bnglr", "Chn", "11-02-2023", "12-02-2023");
		when(dao.save(scd)).thenReturn(scd);
		assertEquals(scd, schedule.createSchedule(scd));
	}
	@Test
	public void findAllScheduleTest(){
		when(dao.findAll()).thenReturn(Stream.of(new Schedule(1, "Bnglr", "Chn", "11-02-2023", "12-02-2023")).collect(Collectors.toList()));
		assertEquals(1,schedule.viewAllSchedule().size());}

}
