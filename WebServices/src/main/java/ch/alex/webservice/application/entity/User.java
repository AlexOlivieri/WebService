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
	@OneToMany(mappedBy="user",targetEntity=Gift.class,fetch=FetchType.EAGER)
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
	
	public Collection<Gift> getGifts(){
		return gifts;
	}
	
	public void setGifts(Collection<Gift> gifts){
		this.gifts = gifts;
	}

}
