package ch.alex.webservice.client.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import retrofit.RestAdapter;
import ch.alex.webservice.application.client.GiftSvcApi;
import ch.alex.webservice.application.entity.Gift;

public class ClientTestGiftCreation {
	
	private final String TEST_URL = "http://localhost:8080";
	
	private GiftSvcApi giftService = new RestAdapter.Builder()
//		.setClient(new ApacheClient())
		.setEndpoint(TEST_URL)
		.setLogLevel(RestAdapter.LogLevel.FULL)
		.build()
		.create(GiftSvcApi.class);
	
	@Test
	public void testGiftAddAndGetList(){
		
		String title = "Title";
		String description = "Description";
		String image = "myImage";
		
		Gift clientGift = new Gift(title, description);
		clientGift.setImage(image);
		Gift gift = giftService.addGift(clientGift);
		
		Collection<Gift> listOfGift = giftService.getGiftList();
		
		assertTrue(listOfGift.contains(gift));
	}

	@Test
	public void testMethod(){
		String title = "First Gift";
		
		boolean response = giftService.testMethod(title);
		
		assertTrue(response);
	}
}