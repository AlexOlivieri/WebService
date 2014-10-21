package ch.alex.webservice.application.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;

@Entity
public class GiftChain {
	
	@Id
	@Column(name = "CHAIN_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "GIFT", nullable = false)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy="giftChain",targetEntity=Gift.class,fetch=FetchType.EAGER)
	private Collection<Gift> gifts;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
//	@JsonIgnore
	private User user;
	
	private GiftChain(){}
	
	public GiftChain(String title, String description){
		super();
		this.title = title;
		this.description = description;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public Collection<Gift> getGifts(){
		return this.gifts;
	}
	
	@JsonIgnore
	public void setGifts(Collection<Gift> gifts){
		this.gifts = gifts;
	}
	
	public User getUser() {
		System.err.println("Within getUser " + user);
		return user;
	}

	public void setUser(User user) {
		System.err.println("Within setUser " + user);
		this.user = user;
	}
	
	/**
	 * Two Videos will generate the same hashcode if they have exactly the same
	 * values for their name, url, and duration.
	 * 
	 */
	@Override
	public int hashCode() {
		// Google Guava provides great utilities for hashing
		return Objects.hashCode(title, description, id);
	}

	/**
	 * Two Videos are considered equal if they have exactly the same values for
	 * their name, url, and duration.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof GiftChain) {
			GiftChain other = (GiftChain) obj;
			// Google Guava provides great utilities for equals too!
			return Objects.equal(title, other.title)
					&& Objects.equal(description, other.description)
					&& id == other.id;
		} else {
			return false;
		}
	}
}
