package my.framework.hibernate.beans;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@DiscriminatorColumn (
		name = "Children_TYPE",
		discriminatorType = DiscriminatorType.STRING
		)
@DiscriminatorValue (value="Mai Vehicle")
@Inheritance
public class Vehicle {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String vehicleName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
