package ch.alex.webservice.application.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.common.base.Objects;

@Entity
//@TransactionConfiguration( defaultRollback = true )
//@Transactional
public class Gift{

	@Id
	@Column(name = "GIFT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "TITLE", nullable = true)
	private String title;
	
	@Column(name = "IMAGE", nullable = true)
	private String image;
	
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;
	//private byte[] image;
	
	private enum Flag{
		normal,
		obscene,
		inappropriate
	};

	@Column(name = "FLAG", nullable = true)
	private Flag photoFlag;
	
	@Column(name = "TOUCH_COUNTER", nullable = true)
	private long touchCounter;
	
	@ElementCollection
	private Collection<User> usersWhoTouchedTheGift;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
//	@JsonIgnore
	private User user;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="CHAIN_ID", referencedColumnName="CHAIN_ID")
//	@JsonIgnore
	private GiftChain giftChain;
	
	public Gift(){}
	
	//public Gift(/*byte[] image,*/ String title, String description) {
	public Gift(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.photoFlag = Flag.normal;
		this.touchCounter = 0;
		
//		System.err.println("Gift: Gift Created");
	}
	
	public long getId() {
		System.err.println("Within getId " + id);
		return id;
	}

	public void setId(long id){
		System.err.println("Within setId " + id);
		this.id = id;
	}
	
	public String getTitle() {
		System.err.println("Within getTitle " + title);
		return title;
	}

	public void setTitle(String title){
		System.err.println("Within setTitle " + title);
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage(){
		return this.image;
	}
	
	public void setImage(String image){
		this.image = image;
	}
	
	public Collection<User> getUsersWhoTouchedTheGift(){
		return usersWhoTouchedTheGift;
	}
	
	//public void setUsersWhoTouchedTheGift(Collection<String> usersWhoTouchedTheGift){
	public void setUsersWhoTouchedTheGift(Collection<User> usersWhoTouchedTheGift){
		this.usersWhoTouchedTheGift = usersWhoTouchedTheGift;
	}
	
	public long getTouchCounter(){
		return touchCounter;
	}
	
	public void setTouchCounter(long touchers){
		this.touchCounter = touchers;
	}
	
	
	public Flag getPhotoFlag(){
		return photoFlag;
	}
	
	public void setPhotoFlaf(Flag flag){
		
		if(flag == Flag.obscene){
			this.photoFlag = Flag.obscene;
		}else if(flag == Flag.inappropriate){
			this.photoFlag = Flag.inappropriate;
		}
	}
	
	public User getUser() {
		System.err.println("Within getUser " + user);
		return user;
	}

	public void setUser(User user) {
		System.err.println("Within setUser " + user);
		this.user = user;
	}
	
	public GiftChain getGiftChain() {
		System.err.println("Within getUser " + user);
		return giftChain;
	}

	public void setGiftChain(GiftChain giftChain) {
		System.err.println("Within setUser " + user);
		this.giftChain = giftChain;
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
		if (obj instanceof Gift) {
			Gift other = (Gift) obj;
			// Google Guava provides great utilities for equals too!
			return Objects.equal(title, other.title)
					&& Objects.equal(description, other.description)
					&& id == other.id;
		} else {
			return false;
		}
	}
}
