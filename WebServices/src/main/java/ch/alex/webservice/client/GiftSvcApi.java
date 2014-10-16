package ch.alex.webservice.client;

import java.util.Collection;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import ch.alex.webservice.application.repository.Gift;

public interface GiftSvcApi {
	
	public static final String GIFT_PATH = "/gift";
	
	@GET(GIFT_PATH)
	public Collection<Gift> getGiftList();
	
	@POST(GIFT_PATH)
	public boolean addGift(@Body Gift g);

}
