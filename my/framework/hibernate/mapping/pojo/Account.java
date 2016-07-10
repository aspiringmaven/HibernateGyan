package my.framework.hibernate.mapping.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Account {
	@GenericGenerator(name="accountGenerator", strategy="increment")
	@Id @GeneratedValue(strategy=GenerationType.AUTO , generator="accountGenerator")
	private int id;
	private String owner;
	private float balance;
	@OneToOne(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ATM atm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}
	
	@Override
	public String toString() {		
		return "ID : "+getId()+" owner : "+getOwner()+" balance : "+getBalance()+" "+getAtm();
	}
	
}
