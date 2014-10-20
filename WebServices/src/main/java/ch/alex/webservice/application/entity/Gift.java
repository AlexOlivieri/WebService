package ch.alex.webservice.application.entity;

import java.util.Collection;

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
public class Gift{

	@Id
	@Column(name = "GIFT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "TITLE", nullable = false)
	private String title;
	
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;
	//private byte[] image;
	
	private enum Flag{
		normal,
		obscene,
		inappropriate
	};

	@Column(name = "FLAG", nullable = false)
	private Flag photoFlag;
	
	@Column(name = "TOUCH_COUNTER", nullable = false)
	private long touchCounter;
	
	@ElementCollection
	private Collection<String> usersWhoTouchedTheGift;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="USER_ID",referencedColumnName="USER_ID")
	private User user;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="CHAIN_ID",referencedColumnName="CHAIN_ID")
	private GiftChain giftChain;
	
	public Gift(){}
	
	//public Gift(/*byte[] image,*/ String title, String description) {
	public Gift(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		//this.usersWhoTouchedTheGift = new HashSet<String>();
		this.photoFlag = Flag.normal;
		this.touchCounter = 0;
		
//		System.err.println("Gift: Gift Created");
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id){
		this.id = id;
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
	
	public Collection<String> getToucher(){
		return usersWhoTouchedTheGift;
	}
	
	public void setToucher(Collection<String> usersWhoTouchedTheGift){
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
	
	public User getCustomer() {
		return user;
	}

	public void setCustomer(User user) {
		this.user = user;
	}
	
	public GiftChain getGiftChain() {
		return giftChain;
	}

	public void setCustomer(GiftChain giftChain) {
		this.giftChain = giftChain;
	}

	
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
