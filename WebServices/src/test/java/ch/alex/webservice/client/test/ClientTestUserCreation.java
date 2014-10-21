package ch.alex.webservice.client.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import retrofit.RestAdapter;
import ch.alex.webservice.application.client.GiftSvcApi;
import ch.alex.webservice.application.client.UserSvcApi;
import ch.alex.webservice.application.entity.Gift;
import ch.alex.webservice.application.entity.User;

public class ClientTestUserCreation {
	
	private final String TEST_URL = "http://localhost:8080";
	
	private UserSvcApi userService = new RestAdapter.Builder()
//	.setClient(new ApacheClient())
	.setEndpoint(TEST_URL)
	.setLogLevel(RestAdapter.LogLevel.FULL)
	.build()
	.create(UserSvcApi.class);

	
	@Test
	public void testAddUserAndGetList(){
		
		User user = userService.addUser(new User("User1"));
		
		Collection<User> listOfUsers = userService.getListOfUsers();
		
		assertTrue(listOfUsers.contains(user));
	}
}
