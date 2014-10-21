package ch.alex.webservice.application.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.alex.webservice.application.entity.GiftChain;
import ch.alex.webservice.application.repository.ChainRepository;

import com.google.common.collect.Lists;

@Controller
public class GiftChainController{
	
	private final String CHAIN_PATH = "/chain";
	
	@Autowired
	private ChainRepository chainRepository;
	
	@RequestMapping(value="/goChain", method=RequestMethod.GET)
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
	@RequestMapping(value=CHAIN_PATH, method=RequestMethod.GET)
	public @ResponseBody Collection<GiftChain> getGiftChain() {
		return Lists.newArrayList(chainRepository.findAll());
		//return giftRepository;
	}
	
	/*
	 * POST /gift
	 * - The gift metadata is provided as an application/json request body.
	 * - Returns the JSON representation of the Gift object that was stored
	 *   along with with any updates to that object made by the server.
	 */
	@RequestMapping(value=CHAIN_PATH, method=RequestMethod.POST)
	public @ResponseBody GiftChain addUser(@RequestBody GiftChain chain){
		//gift.setTouchCounter(0);
		GiftChain newChain = chainRepository.save(chain);
		System.err.println("User Saved");
		return newChain;
	}
}