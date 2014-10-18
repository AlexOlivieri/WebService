package ch.alex.webservice.client.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import ch.alex.webservice.application.client.GiftSvcApi;
import ch.alex.webservice.application.repository.Gift;

public class GiftSvcClientApiTest {

	private class ErrorRecorder implements ErrorHandler {

		private RetrofitError error;

		public Throwable handleError(RetrofitError cause) {
			error = cause;
			return error.getCause();
		}

		public RetrofitError getError() {
			return error;
		}
	}
	
	private final String TEST_URL = "http://localhost:8080";
	
	private GiftSvcApi giftService = new RestAdapter.Builder()
//		.setClient(new ApacheClient())
		.setEndpoint(TEST_URL)
		.setLogLevel(RestAdapter.LogLevel.FULL)
		.build()
		.create(GiftSvcApi.class);
	
	@Test
	public void testGiftAddAndGetList(){
		
		String title = "title";
		String description = "description";
		
		Gift gift = new Gift(title, description);
		
		boolean response = giftService.addGift(gift);
		
		assertTrue(response);
		
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
