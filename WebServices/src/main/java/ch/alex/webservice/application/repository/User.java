package ch.alex.webservice.application.repository;

import java.util.Set;

//@Entity
public class User {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String username;
	
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
//	@JoinColumn(name="owner_id")
	private Set<Gift> gifts;
	
	private User(){
	}
	
	public User(String username){
		this.username = username;
	}

}
