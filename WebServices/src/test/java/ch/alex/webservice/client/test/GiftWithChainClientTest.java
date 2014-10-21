package ch.alex.webservice.client.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import retrofit.RestAdapter;
import ch.alex.webservice.application.client.ChainSvcApi;
import ch.alex.webservice.application.client.GiftSvcApi;
import ch.alex.webservice.application.entity.Gift;
import ch.alex.webservice.application.entity.GiftChain;
import ch.alex.webservice.application.entity.User;

public class GiftWithChainClientTest {
	
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

	
	@Test
	public void testGiftAddAndGetList(){
		
		String title = "Title";
		String description = "Description";
		
		GiftChain chain = chainService.addChain(new GiftChain(title, description));
		
		Collection<GiftChain> listOfChain = chainService.getListOfChain();
		
		Iterator<GiftChain> iterator = listOfChain.iterator();
		
		LinkedList<Long> listOfId = new LinkedList<Long>();
		long id;
		while(iterator.hasNext()){
			GiftChain newChain = iterator.next();
			id = newChain.getId();
			listOfId.add(id);
		}
		
		assertTrue(listOfId.contains(chain.getId()));
		
		Gift gift = new Gift(title, description);
		gift.setGiftChain(chain);
		//gift.setGiftChain(chain);
		
		
		Gift newGift = giftService.addGift(gift);
		
		//assertTrue(newGift);
		
		Collection<Gift> listOfGift = giftService.getGiftList();
		
		Iterator<Gift> iterator2 = listOfGift.iterator();

		boolean userContained = false;
		while(iterator2.hasNext()){
			Gift gifts = iterator2.next();
			if(gifts.getGiftChain().getId() == chain.getId()){
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
