package com.cg.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.fms.dao.AdminDao;
import com.cg.fms.dao.AirportDao;
import com.cg.fms.dao.ScheduleDao;
import com.cg.fms.entities.Admin;
import com.cg.fms.exceptions.NoScheduleFoundException;
import com.cg.fms.services.AdminService;
import com.cg.fms.services.AirportService;
import com.cg.fms.services.ScheduleService;

@SpringBootTest
class AdminTests {
	
	@Autowired
	private AdminService aser;
	
	@MockBean
	private AdminDao adao ;
	
	@MockBean
	private AirportService as;
	
	@MockBean
	private AirportDao ad;
	
	@MockBean 
	ScheduleDao sd;
	
	@MockBean
	ScheduleService ss;
	
	
	@Test
	public void addAdminTest() {
		Admin admin = new Admin(1, "Maggiboy","rightuu12345" );
		when(adao.save(admin)).thenReturn(admin);
		String a = aser.addAdmin(admin);
		assertEquals("Admin Added Successfully", a);
		}
	
	@Test
	public void testAuthenticateAdminIncorrectPassword() {
	    Admin admin = new Admin();
	    admin.setAdminId(1);
	    admin.setAdminName("testAdmin");
	    admin.setAdminPassword("incorrectPassword");
	    
	    Admin mockAdmin = new Admin();
	    mockAdmin.setAdminId(1);
	    mockAdmin.setAdminName("testAdmin");
	    mockAdmin.setAdminPassword("password");
	    
	    when(adao.findById(1)).thenReturn(Optional.of(mockAdmin));
	    
	    String result = aser.authenticateAdmin(admin);
	    
	    verify(adao, times(1)).findById(1);
	    assertEquals("Incorrect Username or Password", result);
	}
	
	@Test
	public void testAuthenticateAdminSuccess() {
	    Admin admin = new Admin();
	    admin.setAdminId(1);
	    admin.setAdminName("testAdmin");
	    admin.setAdminPassword("password");
	    
	    Admin mockAdmin = new Admin();
	    mockAdmin.setAdminId(1);
	    mockAdmin.setAdminName("testAdmin");
	    mockAdmin.setAdminPassword("password");
	    
	    when(adao.findById(1)).thenReturn(Optional.of(mockAdmin));
	    
	    String result = aser.authenticateAdmin(admin);
	    
	    verify(adao, times(1)).findById(1);
	    assertEquals("Authenticated Successfully", result);
	}
	
	@Test
	public void testAuthenticateAdminAdminNotFound() {
	    Admin admin = new Admin();
	    admin.setAdminId(1);
	    admin.setAdminName("testAdmin");
	    admin.setAdminPassword("password");
	    
	    when(adao.findById(1)).thenReturn(Optional.empty());
	    
	    String result = aser.authenticateAdmin(admin);
	    
	    verify(adao, times(1)).findById(1);
	    assertEquals(null, result);
	}
	
	@Test
	public void testViewAllAirports_NoAirportsFound() {
	    when(ad.findAll()).thenReturn(Collections.emptyList());
	    as.viewAllAirport();
	}
	
	@Test
	public void testViewAirportByCode_NotFound() {
	    when(ad.findById("AAA")).thenReturn(Optional.empty());
	    as.viewAirportByCode("AAA");
	}
	
	@Test
	public void testViewScheduleNotFound() throws NoScheduleFoundException {
	    long scheduleId = 1;
	    
	    when(sd.findById(scheduleId)).thenReturn(Optional.empty());
	    
	    ss.viewSchedule(scheduleId);
	}
	
	@Test
	public void testViewAllScheduleNotFound() throws NoScheduleFoundException {
	    when(sd.findAll()).thenReturn(Collections.emptyList());
	    
	    ss.viewAllSchedule();
	}
	
	@Test
	public void testDeleteScheduleNotFound() throws NoScheduleFoundException {
		long scheduleId =1;
	    when(sd.findById(scheduleId)).thenReturn(Optional.empty());
	    
	    ss.deleteSchedule(1);
	}
	
}
	
	
//	
//	@Test
//	public void createScheduleTest() {
//	  Schedule schedule = new Schedule(1,"New Yoork","London");
////	  schedule.setSid(1);
////	  schedule.setSourceAirport("New York");
////	  schedule.setDestinationAirport("London");
////	  
//	  
//	  Mockito.when(sd.save(schedule)).thenReturn(schedule);
//	  
//	  Schedule result = ss.createSchedule(schedule);
//	  assertEquals(schedule, result);
//	}


//@Test
//public void testViewScheduleSuccess() throws NoScheduleFoundException {
//    long scheduleId = 1;
//    Schedule expectedSchedule = new Schedule();
//    expectedSchedule.setSid(scheduleId);
//   
//    
//    Optional<Schedule> scheduleOptional = Optional.of(expectedSchedule);
//    
//    when(sd.findById(scheduleId)).thenReturn(scheduleOptional);
//    
//    Schedule actualSchedule = ss.viewSchedule(scheduleId);
//    
//    verify(sd, times(1)).findById(scheduleId);
//    assertEquals(expectedSchedule, actualSchedule);
//} 
//@Test
//public void testViewAirportByCode_Found() {
//    Airport expectedAirport = new Airport("AAA", "Airport 1", "City 1");
//    when(airportDao.findById("AAA")).thenReturn(Optional.of(expectedAirport));
//    Airport actualAirport = airportService.viewAirportByCode("AAA");
//    assertNotNull(actualAirport);
//    assertEquals(expectedAirport, actualAirport);
//}

