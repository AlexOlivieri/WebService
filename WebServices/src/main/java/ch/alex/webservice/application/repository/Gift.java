package ch.alex.webservice.application.repository;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gift{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String description;
	//private byte[] image;
	
	private enum Flag{
		normal,
		obscene,
		inappropriate
	};
	
	private Flag photoFlag;
	
//	private long touchCounter;
	
	@ElementCollection
	private Collection<String> usersWhoTouchedTheGift;
	
	//public Gift(/*byte[] image,*/ String title, String description) {
	public Gift(String title, String description) {
		super();
		this.title = title;
		this.description = description;
//		this.usersWhoTouchedTheGift = new HashSet<String>();
//		this.photoFlag = Flag.normal;
//		this.touchCounter = 0;
		
//		System.err.println("Gift: Gift Created");
	}
	
/*	public void setTouchCounter(long touchers){
		this.touchCounter = touchers;
	}
*/	
	public void setFlaf(Flag flag){
		
		if(flag == Flag.obscene){
			this.photoFlag = Flag.obscene;
		}else if(flag == Flag.inappropriate){
			this.photoFlag = Flag.inappropriate;
		}
	}
}
