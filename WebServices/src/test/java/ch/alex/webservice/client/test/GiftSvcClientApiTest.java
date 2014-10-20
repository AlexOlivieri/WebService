package ch.alex.webservice.client.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import retrofit.RestAdapter;
import ch.alex.webservice.application.client.GiftSvcApi;
import ch.alex.webservice.application.entity.Gift;
import ch.alex.webservice.application.entity.User;

public class GiftSvcClientApiTest {
	
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
		
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("testjpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		User user = new User("User1");
		em.persist(user);
		
		//GiftChain chain = new GiftChain("Chain1","Test");
		
		Gift gift = new Gift(title, description);
		gift.setUser(user);
		//gift.setGiftChain(chain);
		
		
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
