package ch.alex.webservice.application.client;

import java.util.Collection;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import ch.alex.webservice.application.entity.GiftChain;
import ch.alex.webservice.application.entity.User;

public interface ChainSvcApi {
	
	public static final String CHAIN_PATH = "/chain";
	
	@GET(CHAIN_PATH)
	public Collection<GiftChain> getListOfChain();
	
	@POST(CHAIN_PATH)
	public GiftChain addChain(@Body GiftChain chain);

}
