package ch.alex.webservice.application.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;

@Entity
public class User {

	@Id
	@Column(name = "USER_ID", nullable = true)
	//@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "USERNAME", nullable = true)
	private String username;
	
/*	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="owner_id")
	private Collection<Gift> gifts;
*/	
	
	@Column(name = "GIFT", nullable = true)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy="user",targetEntity=Gift.class,fetch=FetchType.EAGER)
//	@JsonIgnore
	private Collection<Gift> gifts;
	
	@Column(name = "GIFT_CHAIN", nullable = true)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy="user",targetEntity=GiftChain.class,fetch=FetchType.EAGER)
//	@JsonIgnore
	private Collection<GiftChain> giftChains;
	
	private User(){}
	
	public User(String username){
		this.username = username;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id){
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}
	
	@JsonIgnore
	public Collection<Gift> getGifts(){
		return gifts;
	}
	
	
	public void setGifts(Collection<Gift> gifts){
		this.gifts = gifts;
	}
	
	@JsonIgnore
	public Collection<GiftChain> getGiftChains(){
		return giftChains;
	}
	
	
	public void setGiftChain(Collection<GiftChain> giftChains){
		this.giftChains = giftChains;
	}
	
	/**
	 * Two Videos will generate the same hashcode if they have exactly the same
	 * values for their name, url, and duration.
	 * 
	 */
	@Override
	public int hashCode() {
		// Google Guava provides great utilities for hashing
		return Objects.hashCode(username, id);
	}

	/**
	 * Two Videos are considered equal if they have exactly the same values for
	 * their name, url, and duration.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User other = (User) obj;
			// Google Guava provides great utilities for equals too!
			return Objects.equal(username, other.username)
					&& id == other.id;
		} else {
			return false;
		}
	}

}
