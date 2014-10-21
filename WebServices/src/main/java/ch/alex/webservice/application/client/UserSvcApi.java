package ch.alex.webservice.application.client;

import java.util.Collection;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import ch.alex.webservice.application.entity.User;

public interface UserSvcApi {
	
	public static final String USER_PATH = "/user";
	
	@GET(USER_PATH)
	public Collection<User> getListOfUsers();
	
	@POST(USER_PATH)
	public User addUser(@Body User user);

}
