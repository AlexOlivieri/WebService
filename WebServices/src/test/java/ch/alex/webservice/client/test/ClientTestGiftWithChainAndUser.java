package ch.alex.webservice.client.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import retrofit.RestAdapter;
import ch.alex.webservice.application.client.ChainSvcApi;
import ch.alex.webservice.application.client.GiftSvcApi;
import ch.alex.webservice.application.client.UserSvcApi;
import ch.alex.webservice.application.entity.Gift;
import ch.alex.webservice.application.entity.GiftChain;
import ch.alex.webservice.application.entity.User;

public class ClientTestGiftWithChainAndUser {
	
	private final String TEST_URL = "http://localhost:8080";
	
	private GiftSvcApi giftService = new RestAdapter.Builder()
//		.setClient(new ApacheClient())
		.setEndpoint(TEST_URL)
		.setLogLevel(RestAdapter.LogLevel.FULL)
		.build()
		.create(GiftSvcApi.class);
	
	private ChainSvcApi chainService = new RestAdapter.Builder()
//	.setClient(new ApacheClient())
	.setEndpoint(TEST_URL)
	.setLogLevel(RestAdapter.LogLevel.FULL)
	.build()
	.create(ChainSvcApi.class);
	
	private UserSvcApi userService = new RestAdapter.Builder()
//	.setClient(new ApacheClient())
	.setEndpoint(TEST_URL)
	.setLogLevel(RestAdapter.LogLevel.FULL)
	.build()
	.create(UserSvcApi.class);

	@Test
	public void testGiftAddAndGetList(){
		
		String username = "User1";
		User user = userService.addUser(new User(username));
		
		assertTrue(userService.getListOfUsers().contains(user));
		
		String title = "Title";
		String description = "Description";
		
		GiftChain chain = chainService.addChain(new GiftChain(title, description));
		chain.setUser(user);
		
		assertTrue(chainService.getListOfChain().contains(chain));
		
		Gift gift = new Gift(title, description);
		String image = "myImage";
		gift.setImage(image);
		gift.setGiftChain(chain);
		gift.setUser(user);
		
		Gift newGift = giftService.addGift(gift);
		
		assertTrue(giftService.getGiftList().contains(newGift));
		
		
	}

	@Test
	public void testMethod(){
		String title = "First Gift";
		
		boolean response = giftService.testMethod(title);
		
		assertTrue(response);
	}
}
