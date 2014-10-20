package ch.alex.webservice.application.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.alex.webservice.application.repository.User;
import ch.alex.webservice.application.repository.UserRepository;

import com.google.common.collect.Lists;

@Controller
public class UserController{
	
	private final String USER_PATH = "/users";
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/goUser", method=RequestMethod.GET)
	public @ResponseBody String goodLuck(){
		return "Good Luck";
	}
	
	/* GET /user
	 * - Returns the list of Gift that have been added to the
	 *   server as JSON. The list of videos should be persisted
	 *   using Spring Data. 
	 * - The list of Gift objects should be able 
	 *   to be unmarshalled by the client into a Collection<Gift>.
	 * - The return content-type should be application/json, which
	 *   will be the default if you use @ResponseBody
	 */
	@RequestMapping(value=USER_PATH, method=RequestMethod.GET)
	public @ResponseBody Collection<User> getUserList() {
		return Lists.newArrayList(userRepository.findAll());
		//return giftRepository;
	}
	
	/*
	 * POST /gift
	 * - The gift metadata is provided as an application/json request body.
	 * - Returns the JSON representation of the Gift object that was stored
	 *   along with with any updates to that object made by the server.
	 */
/*	@RequestMapping(value=GIFT_PATH, method=RequestMethod.POST)
	public @ResponseBody Gift addGift(@RequestBody Gift gift){
		//gift.setTouchCounter(0);
		Gift newGift = giftRepository.save(gift);
		System.err.println("Gift Saved");
		return newGift;
	}
*/

/*	@RequestMapping(value=GIFT_PATH, method=RequestMethod.POST)
	public @ResponseBody boolean addGift(@RequestBody Gift g){
		
		System.err.println("Gift Controller: Within AddGift");
		
		//gift.setTouchCounter(0);
		Gift newGift = giftRepository.save(g);
		//boolean answer = giftRepository.add(g);
		
		System.err.println("Gift Controller: Gift Saved");
		
		return true;
	}
*/	
	/*
	 * Ok - Tested and Works
	 */
/*	@RequestMapping(value=GIFT_TITLE, method=RequestMethod.POST)
	public @ResponseBody boolean testMethod(@RequestBody String title){
		
		System.err.println("Gift Controller: Within testMethod");
		
		return true;
	}
*/
}