package ch.alex.webservice.application.repository;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
public class GiftChain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String description;
	
	@ManyToOne
	//private Set<Gift> giftOfTheChain;
	private Gift giftOfTheChain;
	
	private GiftChain(){
	}
	
	public GiftChain(String title, String description){
		this.title = title;
		this.description = description;
	}

}
