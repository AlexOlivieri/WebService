package ch.alex.webservice.repository;

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
	private Set<Gift> gifts;
	
	private User(){
	}
	
	public User(String username){
		this.username = username;
	}

}
