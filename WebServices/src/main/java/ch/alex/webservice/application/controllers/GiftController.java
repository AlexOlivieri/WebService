package ch.alex.webservice.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.alex.webservice.application.repository.Gift;
import ch.alex.webservice.application.repository.GiftRepository;

@Controller
public class GiftController {
	
	private final String GIFT_PATH = "/gift";
	
	@Autowired
	private GiftRepository giftRepository;
	
	@RequestMapping(value="/go", method=RequestMethod.GET)
	public @ResponseBody String goodLuck(){
		return "Good Luck";
	}
	
	/*
	 * POST /gift
	 * - The gift metadata is provided as an application/json request body.
	 * - Returns the JSON representation of the Gift object that was stored
	 *   along with with any updates to that object made by the server.
	 */
	@RequestMapping(value=GIFT_PATH, method=RequestMethod.POST)
	public @ResponseBody Gift addGift(@RequestBody Gift gift){
		gift.setTouchCounter(0);
		giftRepository.save(gift);
		return gift;
	}

}
