package ch.alex.webservice.application.repository;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String username;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="owner_id")
	private Collection<Gift> gifts;
	
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
	
	public Collection<Gift> getGiftsBelongingToTheUser(){
		return gifts;
	}
	
	public void setGifts(Collection<Gift> gifts){
		this.gifts = gifts;
	}

}
