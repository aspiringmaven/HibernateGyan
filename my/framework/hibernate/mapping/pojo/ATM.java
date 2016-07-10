package my.framework.hibernate.mapping.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ATM {
		
	@GenericGenerator(name="atmGenerator", strategy="increment")
	@Id @GeneratedValue(strategy=GenerationType.AUTO , generator="atmGenerator")
	private int id;
	private int cardNumber;
	private String cardType;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	@Override
	public String toString() {		
		return "Id : "+getId()+" card Number : "+getCardNumber()+" cardType "+getCardType();
	}
}
