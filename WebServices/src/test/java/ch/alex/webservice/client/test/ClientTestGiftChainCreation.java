package ch.alex.webservice.client.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import retrofit.RestAdapter;
import ch.alex.webservice.application.client.ChainSvcApi;
import ch.alex.webservice.application.entity.GiftChain;

public class ClientTestGiftChainCreation {
	
	private final String TEST_URL = "http://localhost:8080";
	
	private ChainSvcApi chainService = new RestAdapter.Builder()
//	.setClient(new ApacheClient())
	.setEndpoint(TEST_URL)
	.setLogLevel(RestAdapter.LogLevel.FULL)
	.build()
	.create(ChainSvcApi.class);

	
	@Test
	public void testAddChainAndGetList(){
		
		String title = "Title";
		String description = "Description";

		GiftChain chain = chainService.addChain(new GiftChain(title, description));
		
		Collection<GiftChain> listOfGift = chainService.getListOfChain();
		
		assertTrue(listOfGift.contains(chain));
	}
}
