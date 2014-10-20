package ch.alex.webservice.application.client;

import java.util.Collection;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import ch.alex.webservice.application.entity.Gift;

public interface GiftSvcApi {
	
	public static final String GIFT_PATH = "/gift";
	public static final String GIFT_TITLE = "/giftTitle";
	
	@GET(GIFT_PATH)
	public Collection<Gift> getGiftList();
	
	@POST(GIFT_PATH)
	public boolean addGift(@Body Gift gift);
	
	@POST(GIFT_TITLE)
	public boolean testMethod(@Body String title);

}
