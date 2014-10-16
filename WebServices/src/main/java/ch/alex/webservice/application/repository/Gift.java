package ch.alex.webservice.application.repository;

import java.util.Collection;

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
	private byte[] image;
	
	private enum Flag{
		normal,
		obscene,
		inappropriate
	};
	
	private Flag photoFlag;
	
	private long touchCounter;
	
	@ElementCollection
	private Collection<String> usersWhoTouchedTheGift;
	
	private Gift(){
	}

	public Gift(byte[] image, String title, String description) {
		
		this.image = image;
		this.title = title;
		this.description = description;
		this.photoFlag = Flag.normal;
		this.touchCounter = 0;
	}
	
	public void setTouchCounter(long touchers){
		this.touchCounter = touchers;
	}
	
	public void setFlaf(Flag flag){
		
		if(flag == Flag.obscene){
			this.photoFlag = Flag.obscene;
		}else if(flag == Flag.inappropriate){
			this.photoFlag = Flag.inappropriate;
		}
	}
}
