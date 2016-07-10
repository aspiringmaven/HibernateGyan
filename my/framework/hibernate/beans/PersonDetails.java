package my.framework.hibernate.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonDetails {
	@Id
	private int id;
	private String name;
	private int age;
	
	public PersonDetails() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "PersonDetails [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
