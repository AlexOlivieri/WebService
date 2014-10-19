package ch.alex.webservice.application.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.common.base.Objects;

@Entity
public class Gift{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String description;
	//private byte[] image;
	
/*	private enum Flag{
		normal,
		obscene,
		inappropriate
	};
*/
	
//	private Flag photoFlag;
	
//	private long touchCounter;
	
//	@ElementCollection
//	private Collection<String> usersWhoTouchedTheGift;
	
	public Gift(){}
	
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
	
	public long getId() {
		return id;
	}

	public void setId(long id){
		this.id = id;
	}
	
/*	public void setTouchCounter(long touchers){
		this.touchCounter = touchers;
	}
*/	
	
	
/*	public void setFlaf(Flag flag){
		
		if(flag == Flag.obscene){
			this.photoFlag = Flag.obscene;
		}else if(flag == Flag.inappropriate){
			this.photoFlag = Flag.inappropriate;
		}
	}
*/
	
	/**
	 * Two Gifts will generate the same hashcode if they have exactly the same
	 * values for their title, description, and duration.
	 * 
	 */
	@Override
	public int hashCode() {
		// Google Guava provides great utilities for hashing
		return Objects.hashCode(title, description);
	}

	/**
	 * Two Gifts are considered equal if they have exactly the same values for
	 * their title, description, and duration.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Gift) {
			Gift other = (Gift) obj;
			// Google Guava provides great utilities for equals too!
			return Objects.equal(title, other.title)
					&& Objects.equal(description, other.description);
		} else {
			return false;
		}
	}
}
