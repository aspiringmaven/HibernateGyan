package my.framework.hibernate.mapping.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * @author Sumit Kawatra
 *
 */
@Entity
public class CustomerDetails {
	@Id
	@GeneratedValue
	@Column(name = "cardID_PK")
	private int CardId;
	private int income;
	private String designation;
	private String Company;
	@OneToOne(mappedBy = "customerDetails", cascade = CascadeType.ALL)
	private Customer customer;

	public int getCardId() {
		return CardId;
	}

	public void setCardId(int cardId) {
		CardId = cardId;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}