package ch.alex.webservice.client.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Collection;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import ch.alex.webservice.application.repository.Gift;
import ch.alex.webservice.client.GiftSvcApi;

public class GiftSvcClientApiTest {

	private final String TEST_URL = "http://localhost:8080";
	
	private GiftSvcApi giftService = new RestAdapter.Builder()
		.setEndpoint(TEST_URL)
		.setLogLevel(LogLevel.FULL)
		.build()
		.create(GiftSvcApi.class);
	
	@Test
	public void testGiftAddAndGetList(){
		
		String title = "First Gift";
		String description = "Gift Title 1";
		
		Gift gift = new Gift(title, description);
		
		boolean response = giftService.addGift(gift);
		
		assertTrue(response);
		
		Collection<Gift> listOfGift = giftService.getGiftList();
		
		assertTrue(listOfGift.contains(gift));
	}
}
