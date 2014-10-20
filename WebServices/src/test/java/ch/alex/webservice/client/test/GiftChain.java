package ch.alex.webservice.client.test;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.alex.webservice.application.repository.Gift;

@Entity
public class GiftChain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String description;
	
	@ElementCollection
	@ManyToOne
	private Collection<Gift> giftsOfTheChain = new HashSet<Gift>();
	//private Gift giftOfTheChain;
	
	private GiftChain(){
	}
	
	public GiftChain(String title, String description){
		super();
		this.title = title;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id){
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Collection<Gift> getCollectionGifts(){
		return giftsOfTheChain;
	}
	
	public void setToucher(Collection<Gift> giftsOfTheChain){
		this.giftsOfTheChain = giftsOfTheChain;
	}
	
	
	

}
