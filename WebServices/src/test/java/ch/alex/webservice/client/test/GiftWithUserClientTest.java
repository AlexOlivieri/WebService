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

public class GiftWithUserClientTest {
	
	private final String TEST_URL = "http://localhost:8080";
	
	private GiftSvcApi giftService = new RestAdapter.Builder()
//		.setClient(new ApacheClient())
		.setEndpoint(TEST_URL)
		.setLogLevel(RestAdapter.LogLevel.FULL)
		.build()
		.create(GiftSvcApi.class);
	
	private UserSvcApi userService = new RestAdapter.Builder()
//	.setClient(new ApacheClient())
	.setEndpoint(TEST_URL)
	.setLogLevel(RestAdapter.LogLevel.FULL)
	.build()
	.create(UserSvcApi.class);

	
	@Test
	public void testGiftAddAndGetList(){
		
		String title = "Title";
		String description = "Description";
		
		User user = userService.addUser(new User("User1"));
		
		Collection<User> listOfUsers = userService.getListOfUsers();
		
		Iterator<User> iterator = listOfUsers.iterator();
		
		LinkedList<Long> listOfId = new LinkedList<Long>();
		long id;
		while(iterator.hasNext()){
			User newUser = iterator.next();
			id = newUser.getId();
			listOfId.add(id);
		}
		
		System.err.println("User Username: " +user);
		
		assertTrue(listOfId.contains(user.getId()));
		
		Gift gift = new Gift(title, description);
		gift.setUser(user);
		//gift.setGiftChain(chain);
		
		
		Gift newGift = giftService.addGift(gift);
		
		//assertTrue(newGift);
		
		Collection<Gift> listOfGift = giftService.getGiftList();
		
		Iterator<Gift> iterator2 = listOfGift.iterator();

		boolean userContained = false;
		while(iterator2.hasNext()){
			Gift gifts = iterator2.next();
			if(gifts.getUser().getId() == user.getId()){
				userContained = true;
			}
		}
		
		
		assertTrue(userContained);
	}

	@Test
	public void testMethod(){
		String title = "First Gift";
		
		boolean response = giftService.testMethod(title);
		
		assertTrue(response);
	}
}
