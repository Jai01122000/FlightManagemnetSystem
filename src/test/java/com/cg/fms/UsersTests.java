package com.cg.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.fms.dao.UsersDao;
import com.cg.fms.entities.Users;
import com.cg.fms.exceptions.UsersNotFoundException;
import com.cg.fms.services.UsersService;

@SpringBootTest
public class UsersTests {
	@Autowired
	private UsersService rService;
	@MockBean
	private UsersDao rRepository;

	@Test
	public void addUsersTest() {
		Users us = new Users(1, "Jay", "Jayanth", "Password", 1283763567, "Jay@gmail.com");
		when(rRepository.save(us)).thenReturn(us);
		assertEquals(us, rService.addUser(us));
	}

	@Test
	public void testUpdateUser() {
		// Create a new user object to update
		Users updateUser = new Users(1, "admin", "John Doe", "password123", 1234567890, "johndoe@example.com");
		// Use mockito to mock the userDao and findById method
		when(rRepository.findById(updateUser.getId())).thenReturn(Optional.of(updateUser));
		// Call the updateUser method and verify it returns the updated user object
		Users returnedUser = rService.updateUser(updateUser, updateUser.getId());
		assertEquals(updateUser, returnedUser);
	}

	@Test
	public void testUpdateUserNotFound(){
		Users updateUser = new Users(1, "admin", "John Doe", "password123", 1234567890, "johndoe@example.com");
		when(rRepository.findById(updateUser.getId())).thenReturn(Optional.empty());
		assertThrows(UsersNotFoundException.class, () ->
		{
			rService.updateUser(updateUser, updateUser.getId());});
		}
	
	@Test
	public void testViewUserSuccess() {
		long userId = 1;Users expectedUser = new Users(userId, "user", "John Doe", "password", 1234567890, "john.doe@example.com");
		when(rRepository.findById(userId)).thenReturn(Optional.of(expectedUser));
		Users actualUser = rService.viewUser(userId);
		assertEquals(expectedUser, actualUser);}
	
	@Test
	public void testViewUser() {
		List<Users> expectedUsers = Arrays.asList(new Users(1, "user", "John Doe", "password", 1234567890, "johndoe@email.com"),
				new Users(2, "admin", "Jane Doe", "password", 987654320, "janedoe@email.com"));
		when(rRepository.findAll()).thenReturn(expectedUsers);
		List<Users> actualUsers = rService.viewUser();
		assertEquals(expectedUsers, actualUsers);}
}