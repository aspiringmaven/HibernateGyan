package my.framework.hibernate.mapping.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name="User")
@SecondaryTables({
	@SecondaryTable(name="Order"),
	@SecondaryTable(name="Address")
})
public class OrederEntity {
	@Id
	@GeneratedValue
	private int orderId;

	private String UserName;
	private String productCOde;
	private String quantity;
	private String state;
	private String city;
	private String colony;
	private String house;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getProductCOde() {
		return productCOde;
	}

	public void setProductCOde(String productCOde) {
		this.productCOde = productCOde;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}
}