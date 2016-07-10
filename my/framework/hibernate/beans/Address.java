package my.framework.hibernate.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Address {
	@Id @GeneratedValue 
	private int id;
	private String city;
	private String state;
	private String pincode;
	enum test{MALE,FEMALE};
	@Enumerated(EnumType.ORDINAL)
	private
	test Java;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public test getJava() {
		return Java;
	}
	public void setJava(test java) {
		Java = java;
	}
}