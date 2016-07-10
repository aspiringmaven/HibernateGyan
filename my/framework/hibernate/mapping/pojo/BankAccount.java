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
public class BankAccount {

	@GenericGenerator(name = "bankAccount", strategy = "increment")
	@Id
	@GeneratedValue(generator = "bankAccount", strategy = GenerationType.AUTO)
	private int accountId;
	private float balance;
	private String name;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private BankAccountPlus bankAccountPlus;

	public BankAccountPlus getBankAccountPlus() {
		return bankAccountPlus;
	}

	public void setBankAccountPlus(BankAccountPlus bankAccountPlus) {
		this.bankAccountPlus = bankAccountPlus;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {		
		return " ID : "+this.getAccountId()+" Balance : "+this.getBalance()+" Name : "+this.getName();
	}
}
